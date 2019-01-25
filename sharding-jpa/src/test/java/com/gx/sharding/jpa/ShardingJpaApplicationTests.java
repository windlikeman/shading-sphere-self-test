package com.gx.sharding.jpa;

import com.gx.sharding.jpa.service.SpringEntityTransactionService;
import com.gx.sharding.jpa.service.TransactionService;
import com.gx.sharding.jpa.service.impl.ShardingJDBCTransactionService;
import io.shardingsphere.transaction.api.TransactionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJpaApplicationTests {

    @Resource(name = "jdbcTransactionService")
    private SpringEntityTransactionService SpringEntityTransactionService;

    @Test
    public void contextLoads() {
        SpringEntityTransactionService.processSuccess(false);
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
            transactionService.printData(false);
        }
    }


}

