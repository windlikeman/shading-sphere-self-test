/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.example.repository.api.service;

import com.alibaba.fastjson.JSON;
import io.shardingsphere.example.repository.api.entity.Order;
import io.shardingsphere.example.repository.api.entity.OrderItem;
import io.shardingsphere.example.repository.api.repository.OrderItemRepository;
import io.shardingsphere.example.repository.api.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.json.Json;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonServiceImpl implements CommonService {
    
    @Override
    public void initEnvironment() {
        //如果表不存在创建表
        getOrderRepository().createTableIfNotExists();
        getOrderItemRepository().createTableIfNotExists();
        //清空数据
        getOrderRepository().truncateTable();
        getOrderItemRepository().truncateTable();
    }

    /**
     * 注釋掉查看数据
     */
    @Override
    public void cleanEnvironment() {
//        getOrderRepository().dropTable();
//        getOrderItemRepository().dropTable();
    }
    
    @Transactional
    @Override
    public void processSuccess(final boolean isRangeSharding) {
        System.out.println("-------------- 一个成功的事务 ---------------");
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> orderIds = insertData();
        printData(isRangeSharding);
        deleteData(orderIds);
        printData(isRangeSharding);
        System.out.println("-------------- Process Success Finish --------------");
    }
    
    @Transactional
    @Override
    public void processFailure() {
        System.out.println("-------------- 一个失败的事务 ---------------");
        System.out.println("-------------- Process Failure Begin ---------------");
        insertData();
        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }
    
    private List<Long> insertData() {
        System.out.println("---------------------------- Begin Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        System.out.println("开始插入数据");
        for (int i = 1; i <= 10; i++) {
            Order order = newOrder();
            order.setUserId(i);
            order.setStatus("INSERT_TEST");
            System.out.println(JSON.toJSONString(order));
            getOrderRepository().insert(order);
            OrderItem item = newOrderItem();
            item.setOrderId(order.getOrderId());
            item.setUserId(i);
            item.setStatus("INSERT_TEST");
            System.out.println(JSON.toJSONString(item));
            getOrderItemRepository().insert(item);
            result.add(order.getOrderId());
        }
        System.out.println("---------------------------- collected data but not commit ----------------------------");
        return result;
    }
    
    private void deleteData(final List<Long> orderIds) {
        System.out.println("---------------------------- Delete Data ----------------------------");
        for (Long each : orderIds) {
            System.out.println("根据id删除数据:"+each);
            getOrderRepository().delete(each);
            getOrderItemRepository().delete(each);
        }
    }
    
    @Override
    public void printData(final boolean isRangeSharding) {
        if (isRangeSharding) {
            printDataRange();
        } else {
            printDataAll();
        }
    }
    
    private void printDataRange() {
        System.out.println("---------------------------- Print Order Data -----------------------");
        System.out.println("查找id 1-5之间的数据");
        for (Order order : getOrderRepository().selectRange()) {
            System.out.println(JSON.toJSONString(order));
        }
        System.out.println("---------------------------- Print OrderItem Data -------------------");
        System.out.println("查找id 1-5之间的数据");
        for (OrderItem orderItem : getOrderItemRepository().selectRange()) {
            System.out.println(JSON.toJSONString(orderItem));
        }
    }
    
    private void printDataAll() {
        getOrderRepository().selectAll();
        System.out.println("--------------------------------------------------");
        long before = System.nanoTime();
        List<Order> orders = getOrderRepository().selectAll();
        for (Order order : orders) {
            System.out.println("order:" + JSON.toJSONString(order));
        }
        System.out.println("Total use time:" + (System.nanoTime() - before) + "纳秒");
        System.out.println("---------------------------- Print OrderItem Data -------------------");
        for (OrderItem orderItem : getOrderItemRepository().selectAll()) {
            System.out.println("orderItem:" + JSON.toJSONString(orderItem));
        }
    }
    
    protected abstract OrderRepository getOrderRepository();
    
    protected abstract OrderItemRepository getOrderItemRepository();
    
    protected abstract Order newOrder();
    
    protected abstract OrderItem newOrderItem();
}
