package com.expo.service;


import com.expo.entity.domain.User;
import com.expo.entity.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("expo-sso-service")
@Repository
public interface FeignUserService {

    @PostMapping("/api/user/login")
    BaseResponse<?> login(@RequestBody User user);

    @PostMapping("/api/user/register")
    BaseResponse<?> register(@RequestBody User user);

    @PostMapping("/api/user/autoLogin")
    BaseResponse<?> autoLogin(@RequestBody User user);
}
