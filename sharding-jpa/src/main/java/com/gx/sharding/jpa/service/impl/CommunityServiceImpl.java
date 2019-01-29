package com.gx.sharding.jpa.service.impl;

import com.gx.sharding.jpa.entity.Community;
import com.gx.sharding.jpa.repository.CommunityRepository;
import com.gx.sharding.jpa.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public Community save(Community community) {
        return communityRepository.save(community);
    }
}
