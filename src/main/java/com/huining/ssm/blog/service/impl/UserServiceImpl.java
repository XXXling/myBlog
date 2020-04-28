package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.User;
import com.huining.ssm.blog.mapper.UserMapper;
import com.huining.ssm.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: huining
 * @Date: 2020/4/27 18:08
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(User user) {
        return userMapper.queryUser(user);
    }

    @Override
    public void updateUsere(User user) {
        userMapper.updateUser(user);
    }
}
