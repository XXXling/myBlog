package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: huining
 * @Date: 2020/4/27 18:10
 */
@Mapper
public interface UserMapper {

    BlogUser queryUser(BlogUser blogUser);

    void updateUser(BlogUser blogUser);
}
