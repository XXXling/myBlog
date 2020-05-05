package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/6 00:10
 */
@Data
public class ArticleCategoryRef implements Serializable {

    private static final long serialVersionUID = -6809206515467725995L;

    private Integer articleId;

    private Integer categoryId;

    public ArticleCategoryRef() {
    }

    public ArticleCategoryRef(Integer articleId, Integer categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }
}