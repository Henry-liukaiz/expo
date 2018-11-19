package com.expo.entity.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by liukai on 2018/11/18.
 */
@Setter
@Getter
public class User {

    private Long id;
    private String userName;
    private String passWord;
    private String vserName;
    private String mobile;
    private Date createTime;
    private Date updateTime;
}
