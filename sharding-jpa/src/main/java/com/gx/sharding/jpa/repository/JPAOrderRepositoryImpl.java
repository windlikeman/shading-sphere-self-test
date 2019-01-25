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

import com.gx.sharding.jpa.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JPAOrderRepositoryImpl implements OrderRepository {

    /**
     * 存储接口
     */
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void createTableIfNotExists() {
        throw new UnsupportedOperationException("createTableIfNotExists for JPA");
    }
    
    @Override
    public void truncateTable() {
        throw new UnsupportedOperationException("truncateTable for JPA");
    }
    
    @Override
    public void dropTable() {
        throw new UnsupportedOperationException("dropTable for JPA");
    }
    
    @Override
    public Long insert(final Order order) {
        entityManager.persist(order);
        return order.getOrderId();
    }
    
    @Override
    public void delete(final Long orderId) {
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.orderId = ?1");
        query.setParameter(1, orderId);
        query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Order> selectAll() {
        return (List<Order>) entityManager.createQuery("SELECT o FROM Order o").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Order> selectRange() {
        return (List<Order>) entityManager.createQuery("SELECT o FROM Order o WHERE orderId BETWEEN 200000000000000000 AND 400000000000000000").getResultList();
    }
}
