package com.expo.entity.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private long id;                //id

    private String userName;        //用户名

    private String vserName;        //昵称

    private String password;        //密码

    private String mobile;          //电话号

    private String email;           //邮箱

    private String gender;          //性别

    private String status;          //状态

    private Date lastLoginDateTime; //最后一次登陆时间

    private String portrait;        //头像

    private Date create_time;       //创建时间

    private Date update_time;       //更新时间
}
