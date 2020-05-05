package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogCategory;
import com.huining.ssm.blog.mapper.ArticleCategoryRefMapper;
import com.huining.ssm.blog.mapper.CategoryMapper;
import com.huining.ssm.blog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 17:50
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleCategoryRefMapper articleCategoryRefMapper;

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

    @Override
    public BlogCategory getCategoryById(Integer cateId) {
        BlogCategory category = null;
        try {
            category = categoryMapper.getCategoryById(cateId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据id获取分类信息失败，cause:{}",e);
        }
        return category;
    }

    @Override
    public List<BlogCategory> listCategoryWithCount() {
        List<BlogCategory> categories = null;
        try {
            categories = categoryMapper.listCategory();
            for (BlogCategory category : categories) {
                Integer count = articleCategoryRefMapper.countArticleByCategoryId(category.getCategoryId());
                category.setArticleCount(count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据文章获得分类列表失败，cause:{}",e);
        }
        return categories;
    }

    @Override
    public BlogCategory insertCategory(BlogCategory category) {
        try {
            categoryMapper.insert(category);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("创建分类失败，cause:{}",e);
        }
        return category;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCategory(Integer id) {
        try {
            categoryMapper.delete(id);
            articleCategoryRefMapper.deleteByCategoryId(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除分类失败, id:{}, cause:{}", id, e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

    }

    @Override
    public void updateCategory(BlogCategory category) {
        try {
            categoryMapper.updateCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("更新分类失败, category:{}, cause:{}", category, e);
        }
    }

}
