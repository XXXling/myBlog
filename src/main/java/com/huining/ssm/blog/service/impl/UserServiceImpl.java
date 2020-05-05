package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogUser;
import com.huining.ssm.blog.mapper.UserMapper;
import com.huining.ssm.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: huining
 * @Date: 2020/4/27 18:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BlogUser queryUser(BlogUser blogUser) {
        return userMapper.queryUser(blogUser);
    }

    @Override
    public void updateUsere(BlogUser blogUser) {
        userMapper.updateUser(blogUser);
    }
}
