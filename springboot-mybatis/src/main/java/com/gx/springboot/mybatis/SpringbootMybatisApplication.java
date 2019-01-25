package com.gx.springboot.mybatis;

import io.shardingsphere.example.repository.api.service.CommonService;
import io.shardingsphere.example.repository.mybatis.service.SpringPojoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.shardingsphere.example.repository.mybatis")
@MapperScan(basePackages = "io.shardingsphere.example.repository.mybatis.repository")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class SpringbootMybatisApplication {
    public static void main(final String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootMybatisApplication.class, args)) {
            process(applicationContext);
        }
    }

    private static void process(final ConfigurableApplicationContext applicationContext) {
        CommonService commonService = getCommonService(applicationContext);
        commonService.initEnvironment();
        commonService.processSuccess(false);
        try {
            commonService.processFailure();
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
            commonService.printData(false);
        } finally {
            commonService.cleanEnvironment();
        }
    }

    private static CommonService getCommonService(final ConfigurableApplicationContext applicationContext) {
        return applicationContext.getBean(SpringPojoService.class);
    }
}

