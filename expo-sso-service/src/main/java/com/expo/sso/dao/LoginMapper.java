package com.expo.sso.dao;

import com.expo.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    User check(User user);
}
