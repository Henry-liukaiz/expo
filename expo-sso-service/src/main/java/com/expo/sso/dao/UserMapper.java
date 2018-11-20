package com.expo.sso.dao;

import com.expo.entity.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User login(User user);

    int register(User user);
}
