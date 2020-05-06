package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogLink;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 18:47
 */
public interface LinkService {

    /**
     * 获得链接总数
     *
     * @param status 状态
     * @return 数量
     */
    Integer countLink(Integer status);

    /**
     * create by: huining
     * description:创建链接
     * create time: 21:25 2020/5/5
     * @param link: 
     * @return: void
     */
    void insertLink(BlogLink link);
    
    /**
     * create by: huining
     * description:根据id查找链接
     * create time: 15:34 2020/5/6
     * @param id: 
     * @return: com.huining.ssm.blog.entity.BlogLink
     */
    BlogLink getLinkById(Integer id);

    /**
     * create by: huining
     * description:根据状态查询链接
     * create time: 15:19 2020/5/6
     * @param status: 
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogLink>
     */
    List<BlogLink> listLink(Integer status);

    /**
     * create by: huining
     * description:根据id删除
     * create time: 15:25 2020/5/6
     * @param id: 
     * @return: void
     */
    void deleteLink(Integer id);

    /**
     * create by: huining
     * description:更新链接
     * create time: 15:41 2020/5/6
     * @param link: 
     * @return: void
     */
    void updateLink(BlogLink link);
}
