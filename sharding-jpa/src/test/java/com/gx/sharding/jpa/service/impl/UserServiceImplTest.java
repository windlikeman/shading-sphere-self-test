package com.gx.sharding.jpa.service.impl;

import com.gx.sharding.jpa.ShardingJpaApplicationTests;
import com.gx.sharding.jpa.entity.User;
import com.gx.sharding.jpa.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;

import java.util.Date;


public class UserServiceImplTest extends ShardingJpaApplicationTests {


    @Autowired
    UserService userService;

    @Test
    @Repeat(200)
    public void save() {
        User user = new User();
        user.setCommunityNumber(1001);
        user.setUserName("lyf");
        user.setPassword("215156");
        user.setPhoneNumber(15068710662L);
        user.setStatus("0");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Assert.assertNotNull((userService.save(user)));
    }
}