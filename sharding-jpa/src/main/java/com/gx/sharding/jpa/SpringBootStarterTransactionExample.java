package com.gx.sharding.jpa;

import io.shardingsphere.example.repository.jpa.service.SpringEntityTransactionService;
import io.shardingsphere.example.repository.jpa.service.TransactionService;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.shardingsphere.example.repository.jpa")
@EntityScan(basePackages = "io.shardingsphere.example.repository.jpa.entity")
@SpringBootApplication
public class SpringBootStarterTransactionExample {

    public static void main(final String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarterTransactionExample.class, args)) {
            process(applicationContext);
        }
    }

    private static void process(final ConfigurableApplicationContext applicationContext) {
        TransactionService transactionService = getTransactionService(applicationContext);
        transactionService.processSuccess(false);
        processFailureSingleTransaction(transactionService, TransactionType.LOCAL);
        processFailureSingleTransaction(transactionService, TransactionType.XA);
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

    private static TransactionService getTransactionService(final ConfigurableApplicationContext applicationContext) {
        return applicationContext.getBean("jdbcTransactionService", SpringEntityTransactionService.class);
    }
}
