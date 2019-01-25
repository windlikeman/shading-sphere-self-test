package com.gx.sharding.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liyongfei
 */
@EntityScan(basePackages = "com.gx.sharding.jpa.entity")
@EnableTransactionManagement
@SpringBootApplication
public class SpringBootStarterTransactionExample {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootStarterTransactionExample.class, args);
    }

}
