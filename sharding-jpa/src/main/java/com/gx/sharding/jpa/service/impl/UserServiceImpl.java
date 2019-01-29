package com.gx.sharding.jpa.service.impl;

import com.gx.sharding.jpa.entity.User;
import com.gx.sharding.jpa.repository.UserRepository;
import com.gx.sharding.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyongfei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
