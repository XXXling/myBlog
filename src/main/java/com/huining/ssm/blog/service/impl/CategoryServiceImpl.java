package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogCategory;
import com.huining.ssm.blog.mapper.CategoryMapper;
import com.huining.ssm.blog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 17:50
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    public CategoryMapper categoryMapper;

    /**
     * 获得分类列表
     * @return
     */
    @Override
    public List<BlogCategory> listCategory() {
        List<BlogCategory> categoryList = null;

        try {
            categoryList = categoryMapper.listCategory();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据文章获得分类失败 ,cause:{}" + e);
        }

        return categoryList;
    }

    @Override
    public Integer countCategory() {
        Integer count = 0;

        try {
            count = categoryMapper.countCategory();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取分类总数失败 ,cause:{}" + e);
        }

        return count;
    }
}
