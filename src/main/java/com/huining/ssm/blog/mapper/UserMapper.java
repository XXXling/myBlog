package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/27 18:10
 */
@Mapper
public interface UserMapper {

    /**
     * create by: huining
     * description:查找用户
     * create time: 17:13 2020/5/6
     * @param blogUser:
     * @return: com.huining.ssm.blog.entity.BlogUser
     */
    BlogUser queryUser(BlogUser blogUser);

    /**
     * create by: huining
     * description:更新用户
     * create time: 17:12 2020/5/6
     * @param blogUser:
     * @return: void
     */
    void updateUser(BlogUser blogUser);

    /**
     * create by: huining
     * description:产找用户列表
     * create time: 17:12 2020/5/6

     * @return: java.util.List<com.huining.ssm.blog.entity.BlogUser>
     */
    List<BlogUser> listUser();

    /**
     * create by: huining
     * description:新增用户
     * create time: 17:31 2020/5/6
     * @param user: 
     * @return: void
     */
    void insertUser(BlogUser user);

    /**
     * create by: huining
     * description:删除用户
     * create time: 17:34 2020/5/6
     * @param id: 
     * @return: void
     */
    void deleteUser(@Param("userId") Integer id);
}
