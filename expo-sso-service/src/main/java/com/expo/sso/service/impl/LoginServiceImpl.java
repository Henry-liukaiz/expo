package com.expo.sso.service.impl;

import com.expo.entity.domain.User;
import com.expo.sso.dao.LoginMapper;
import com.expo.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User check(User user) {
        return loginMapper.check(user);
    }
}
