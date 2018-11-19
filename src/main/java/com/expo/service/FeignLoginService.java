package com.expo.service;


import com.expo.entity.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("expo-sso-service")
@ResponseBody
public interface FeignLoginService {

    @PostMapping("/api/login/")
    User check(User user);
}
