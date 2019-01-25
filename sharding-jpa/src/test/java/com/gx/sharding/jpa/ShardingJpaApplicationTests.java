package com.gx.sharding.jpa;

import com.gx.sharding.jpa.service.TransactionService;
import com.gx.sharding.jpa.service.impl.ShardingJDBCTransactionService;
import io.shardingsphere.transaction.api.TransactionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJpaApplicationTests {

    @Autowired
    private ShardingJDBCTransactionService shardingJDBCTransactionService;

    @Test
    public void contextLoads() {
          shardingJDBCTransactionService.processSuccess(false);
//        processFailureSingleTransaction(SpringEntityTransactionService, TransactionType.LOCAL);
//        processFailureSingleTransaction(SpringEntityTransactionService, TransactionType.XA);
//        processFailureSingleTransaction(transactionService, TransactionType.BASE);
//        processFailureSingleTransaction(transactionService, TransactionType.LOCAL);
    }


    private static void processFailureSingleTransaction(final TransactionService transactionService, final TransactionType type) {
        try {
            switch (type) {
                case LOCAL:
                    transactionService.processFailureWithLocal();
                    break;
                case XA:
                    transactionService.processFailureWithXa();
                    break;
                case BASE:
                    transactionService.processFailureWithBase();
                    break;
                default:
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}

