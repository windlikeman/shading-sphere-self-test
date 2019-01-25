package com.gx.sharding.jpa;

import io.shardingsphere.example.repository.jpa.service.CommonService;
import io.shardingsphere.example.repository.jpa.service.SpringEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("io.shardingsphere.example.repository.jpa")
@EntityScan(basePackages = "io.shardingsphere.example.repository.jpa.entity")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class SpringBootStarterExample {

    public static void main(final String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarterExample.class, args)) {
            process(applicationContext);
        }
    }

    private static void process(final ConfigurableApplicationContext applicationContext) {
        CommonService commonService = getCommonService(applicationContext);
        commonService.processSuccess(false);
        try {
            commonService.processFailure();
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            commonService.printData(false);
        }
    }

    private static CommonService getCommonService(final ConfigurableApplicationContext applicationContext) {
        return applicationContext.getBean(SpringEntityService.class);
    }
}
