package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogUser;

/**
 * @Author: huining
 * @Date: 2020/4/24 15:45
 */
public interface UserService {

    BlogUser queryUser(BlogUser blogUser);

    void updateUsere(BlogUser blogUser);
}
