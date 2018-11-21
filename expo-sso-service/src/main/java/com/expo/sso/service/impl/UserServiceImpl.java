package com.expo.sso.service.impl;

import com.expo.entity.domain.User;
import com.expo.sso.dao.UserMapper;
import com.expo.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public User autoLogin(User user) {
        return userMapper.autoLogin(user);
    }
}
