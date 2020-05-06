package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogUser;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/24 15:45
 */
public interface UserService {

    /**
     * create by: huining
     * description:查找用户
     * create time: 17:28 2020/5/6
     * @param blogUser: 
     * @return: com.huining.ssm.blog.entity.BlogUser
     */
    BlogUser queryUser(BlogUser blogUser);

    /**
     * create by: huining
     * description:更新用户
     * create time: 17:10 2020/5/6
     * @param blogUser: 
     * @return: void
     */
    void updateUser(BlogUser blogUser);

    /**
     * create by: huining
     * description:查找用户列表
     * create time: 17:10 2020/5/6
     
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogUser>
     */
    List<BlogUser> listUser();

    /**
     * create by: huining
     * description:新增用户
     * create time: 17:30 2020/5/6
     * @param user: 
     * @return: void
     */
    void insertUser(BlogUser user);

    /**
     * create by: huining
     * description:删除用户
     * create time: 17:33 2020/5/6
     * @param id: 
     * @return: void
     */
    void deleteUser(Integer id);

}
