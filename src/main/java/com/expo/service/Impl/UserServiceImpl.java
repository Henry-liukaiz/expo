package com.expo.service.Impl;

import com.expo.dao.UserMapper;
import com.expo.entity.domain.User;
import com.expo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liukai on 2018/11/18.
 */

@Service
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapper userMapper;
    
    @Override
    public int save(User user) {
        return userMapper.save(user);
    }
}
