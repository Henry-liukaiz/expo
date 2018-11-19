package com.expo.client.Impl;

import com.expo.client.UserResource;
import com.expo.entity.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by liukai on 2018/11/18.
 */
@Component
public class UserClient implements UserResource {


    @Override
    public void login(User user) {
        System.out.println("33333");
    }
}
