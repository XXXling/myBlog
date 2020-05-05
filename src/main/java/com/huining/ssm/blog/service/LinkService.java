package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogLink;

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
}
