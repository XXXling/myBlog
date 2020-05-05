package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/6 00:11
 */
@Data
public class ArticleTagRef implements Serializable {
    private static final long serialVersionUID = -5816783232020910492L;

    private Integer articleId;

    private Integer tagId;

    public ArticleTagRef() {
    }

    public ArticleTagRef(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }
}