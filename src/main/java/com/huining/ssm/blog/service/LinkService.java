package com.huining.ssm.blog.service;

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
}
