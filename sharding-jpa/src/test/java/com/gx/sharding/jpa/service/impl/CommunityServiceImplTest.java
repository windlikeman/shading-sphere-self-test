package com.gx.sharding.jpa.service.impl;

import com.gx.sharding.jpa.ShardingJpaApplicationTests;
import com.gx.sharding.jpa.entity.Community;
import com.gx.sharding.jpa.service.CommunityService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;

import java.util.Date;

import static org.junit.Assert.*;

public class CommunityServiceImplTest extends ShardingJpaApplicationTests {

    @Autowired
    private CommunityService communityService;

    @Test
    @Repeat(200)
    public void save() {
        Community community = new Community();
        community.setName("悦盛国际");
        community.setAddress("中和");
        community.setCommunityNumber(1001);
        community.setCreateTime(new Date());
        community.setModifyTime(new Date());
        Community community2 = communityService.save(community);
        Assert.assertNotNull(community2);
    }
}