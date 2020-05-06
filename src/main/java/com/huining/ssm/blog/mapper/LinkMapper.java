package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/24 13:42
 */
@Mapper
public interface LinkMapper {
    /**
     * create by: huining
     * description:统计链接总数
     * create time: 15:20 2020/5/6
     * @param status:
     * @return: java.lang.Integer
     */
    Integer countLink(@Param("status") Integer status);

    /**
     * create by: huining
     * description:新增 链接
     * create time: 15:20 2020/5/6
     * @param link:
     * @return: void
     */
    void insertLink(BlogLink link);

    /**
     * create by: huining
     * description:根据状态查询链接
     * create time: 15:21 2020/5/6
     * @param status:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogLink>
     */
    List<BlogLink> listLink(@Param("status") Integer status);

    /**
     * create by: huining
     * description:根据id产找链接
     * create time: 15:35 2020/5/6
     * @param id:
     * @return: com.huining.ssm.blog.entity.BlogLink
     */
    BlogLink getLinkById(@Param("id") Integer id);

    void deleteLink(@Param("id") Integer id);

    void updateLink(BlogLink link);
}
