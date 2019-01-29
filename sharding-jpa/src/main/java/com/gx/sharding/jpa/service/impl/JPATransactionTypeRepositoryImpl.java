package com.gx.sharding.jpa.service.impl;

import com.gx.sharding.jpa.entity.TransactionType;
import com.gx.sharding.jpa.service.TransactionTypeService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author liyongfei
 */
@Repository
public class JPATransactionTypeRepositoryImpl implements TransactionTypeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TransactionType showTransactionType() {
        TransactionType result = new TransactionType();
        result.setTransactionType((String) entityManager.createNativeQuery("SCTL\\:SHOW TRANSACTION_TYPE").getSingleResult());
        return result;
    }
}
