package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: huining
 * @Date: 2020/4/27 18:10
 */
@Mapper
public interface UserMapper {

    User queryUser(User user);

    void updateUser(User user);
}
