package com.expo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liukai on 2018/11/18.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping(value = "/test")
    public String test (){
      return "hello";
    }
}
