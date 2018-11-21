package com.expo.controller;

import com.alibaba.fastjson.JSONObject;
import com.expo.entity.domain.User;
import com.expo.entity.response.BaseResponse;
import com.expo.service.FeignUserService;
import com.expo.util.JwtUtil;
import com.expo.util.RandomLetter;
import com.expo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private FeignUserService feignUserService;

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<?> login(User user) {
        return setToken(feignUserService.login(user));
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<?> register(User user) {
        user.setVserName("博览-"+ RandomLetter.run(8));
        user.setPassword(Utils.md5Password(user.getPassword()));
        return setToken(feignUserService.register(user));
    }


    /**
     * 返回token信息
     * @param result
     * @return
     */
    public BaseResponse<?> setToken(BaseResponse result){
        if (result.getCode().equals("0")) {
            //每次登陆、注册成功 生成token返回前台页面
            try {
                //linkedHashMap 转 Object
                User userInfo = JSONObject.parseObject(JSONObject.toJSON(result.getData()).toString(), User.class);
                result.setToken(JwtUtil.createJWT("{userId:" + userInfo.getId() + "}", -120)); //120个小时
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        return result;
    }

    /**
     * 自动登陆
     * @param user
     * @return
     */
    @PostMapping("/autoLogin")
    public BaseResponse<?> autoLogin(User user) {
        return feignUserService.autoLogin(user);
    }
}
