package com.expo.sso.api.controller;

import com.expo.entity.domain.User;
import com.expo.entity.enums.ReturnCode;
import com.expo.entity.response.BaseResponse;
import com.expo.entity.response.BaseResponseBuilder;
import com.expo.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody User user) {
        User u = userService.login(user);
        return u == null
                ? BaseResponseBuilder.buildBaseResponse(ReturnCode.ERROR)
                : BaseResponseBuilder.buildBaseResponse(ReturnCode.SUCCESS, u);
    }

    @PostMapping("/register")
    public BaseResponse<?> register(@RequestBody User user) {
        return userService.register(user) <= 0
                ? BaseResponseBuilder.buildBaseResponse(ReturnCode.ERROR)
                : BaseResponseBuilder.buildBaseResponse(ReturnCode.SUCCESS, user);
    }
}

