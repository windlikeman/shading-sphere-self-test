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

package com.gx.sharding.jpa.repository;

import com.gx.sharding.jpa.entity.OrderItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JPAOrderItemRepositoryImpl implements OrderItemRepository {

    /**
     * 存储接口
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long insert(final OrderItem orderItem) {
        entityManager.persist(orderItem);
        return orderItem.getOrderItemId();
    }
    
    @Override
    public void delete(final Long orderItemId) {
        Query query = entityManager.createQuery("DELETE FROM OrderItem i WHERE i.orderItemId = ?1 AND i.userId = 51");
        query.setParameter(1, orderItemId);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderItem> selectAll() {
        return (List<OrderItem>) entityManager.createQuery("SELECT i FROM Order o, OrderItem i WHERE o.orderId = i.orderId").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderItem> selectRange() {
        return (List<OrderItem>) entityManager.createQuery("SELECT i FROM Order o, OrderItem i WHERE o.orderId = i.orderId AND o.userId BETWEEN 1 AND 5").getResultList();
    }
}
