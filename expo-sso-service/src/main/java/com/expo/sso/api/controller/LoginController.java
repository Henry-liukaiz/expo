package com.expo.sso.api.controller;

import com.expo.entity.domain.User;
import com.expo.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/")
    public User check(User user){
        return loginService.check(user);
    }
}

