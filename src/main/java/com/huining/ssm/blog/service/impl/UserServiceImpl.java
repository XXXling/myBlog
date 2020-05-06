package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogUser;
import com.huining.ssm.blog.mapper.ArticleMapper;
import com.huining.ssm.blog.mapper.UserMapper;
import com.huining.ssm.blog.service.ArticleService;
import com.huining.ssm.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/27 18:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public BlogUser queryUser(BlogUser blogUser) {
        return userMapper.queryUser(blogUser);
    }

    @Override
    public void updateUser(BlogUser blogUser) {
        userMapper.updateUser(blogUser);
    }

    @Override
    public List<BlogUser> listUser() {
        List<BlogUser> users = userMapper.listUser();
        for (BlogUser user : users) {
            Integer count = articleMapper.countArticleByUserId(user.getUserId());
            user.setArticleCount(count);
        }
        return users;
    }

    @Override
    public void insertUser(BlogUser user) {
        user.setUserRegisterTime(new Date());
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
