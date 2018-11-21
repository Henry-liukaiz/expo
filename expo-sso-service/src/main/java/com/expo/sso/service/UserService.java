package com.expo.sso.service;


import com.expo.entity.domain.User;

public interface UserService {
    User login(User user);

    int register(User user);

    User autoLogin(User user);
}
