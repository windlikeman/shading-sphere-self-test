package com.gx.sharding.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author liyongfei
 */
@EntityScan(basePackages = "com.gx.sharding.jpa.entity")
@SpringBootApplication
public class SpringBootStarterTransactionExample {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootStarterTransactionExample.class, args);
    }

}
