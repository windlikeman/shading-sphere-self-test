package com.gx.sharding.jpa.repository;

import com.gx.sharding.jpa.ShardingJpaApplicationTests;
import com.gx.sharding.jpa.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItemRepositoryTest extends ShardingJpaApplicationTests {

    @Autowired
    private OrderRepository orderRepository;
    @Test
    public void saveTest(){
        Order order = new Order();
        order.setUserId(1000);
        order.setStatus("0");
//        orderRepository.save(order);
    }

}