package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.User;

/**
 * @Author: huining
 * @Date: 2020/4/24 15:45
 */
public interface UserService {

    User queryUser(User user);

    void updateUsere(User user);
}
