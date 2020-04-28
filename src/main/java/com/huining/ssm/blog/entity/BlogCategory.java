package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: huining
 * @Date: 2020/4/21 17:48
 */
@Data
public class BlogCategory implements Serializable {
    private static final long serialVersionUID = 6687286913317513141L;

    private Integer categoryId;
    private Integer categoryPid;
    private String categoryName;
    private String categoryDescription;
    private Integer categoryOrder;
    private String categoryIcon;

    /**
     * 文章数量(非数据库字段)
     */
    private Integer articleCount;

    public BlogCategory(Integer categoryId, Integer categoryPid, String categoryName, String categoryDescription, Integer categoryOrder, String categoryIcon,Integer articleCount) {
        this.categoryId = categoryId;
        this.categoryPid = categoryPid;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryOrder = categoryOrder;
        this.categoryIcon = categoryIcon;
        this.articleCount = articleCount;
    }

    public BlogCategory(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public BlogCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 未分类
     *
     * @return 分类
     */
    public static BlogCategory Default() {
        return new BlogCategory(100000000, "未分类");
    }
}
