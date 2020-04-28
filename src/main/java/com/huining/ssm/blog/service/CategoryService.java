package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogCategory;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 17:48
 */
public interface CategoryService {

    /**
     * 获得分类列表
     * @return
     */
    List<BlogCategory> listCategory();

    /**
     *获得分类总数
     *
     * @return
     */
    Integer countCategory();
}
