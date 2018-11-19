package com.expo.controller;

import com.expo.entity.domain.User;
import com.expo.service.FeignLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/login")
@ResponseBody
public class LoginController {

    @Autowired
    private FeignLoginService feignLoginService;

    @PostMapping("/")
    public User check (User user){
        return feignLoginService.check(user);
    }
}
