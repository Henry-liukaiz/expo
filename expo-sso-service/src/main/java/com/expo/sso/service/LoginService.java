package com.expo.sso.service;


import com.expo.entity.domain.User;

public interface LoginService {
    User check(User user);
}
