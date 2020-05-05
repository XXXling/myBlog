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

    /**
     * create by: huining
     * description:根据id获取分类信息
     * create time: 17:43 2020/5/3
     * @param cateId: 
     * @return: com.huining.ssm.blog.entity.BlogCategory
     */
    BlogCategory getCategoryById(Integer cateId);

    /**
     * create by: huining
     * description:获得分类列表
     * create time: 23:57 2020/5/5
     
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogCategory>
     */
    List<BlogCategory> listCategoryWithCount();

    /**
     * create by: huining
     * description:新增分类数据
     * create time: 00:42 2020/5/6
     * @param category: 
     * @return: void
     */
    BlogCategory insertCategory(BlogCategory category);

    /**
     * create by: huining
     * description:根据id删除分类
     * create time: 01:00 2020/5/6
     * @param id: 
     * @return: void
     */
    void deleteCategory(Integer id);

    /**
     * create by: huining
     * description:更新分类
     * create time: 01:08 2020/5/6
     * @param category: 
     * @return: void
     */
    void updateCategory(BlogCategory category);
}
