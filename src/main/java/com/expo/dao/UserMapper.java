package com.expo.dao;

import com.expo.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liukai on 2018/11/18.
 */
@Mapper
public interface UserMapper {
    
    int save(User user);
}
