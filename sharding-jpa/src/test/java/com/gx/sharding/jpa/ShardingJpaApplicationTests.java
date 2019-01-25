package com.gx.sharding.jpa;

import com.gx.sharding.jpa.service.SpringEntityTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJpaApplicationTests {

    @Resource(name = "jdbcTransactionService")
    private SpringEntityTransactionService jdbcTransactionService;

    @Test
    public void contextLoads() {
        jdbcTransactionService.processSuccess(false);
    }




}

