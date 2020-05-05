package com.huining.ssm.blog.entity;

import com.huining.ssm.blog.enums.ArticleStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 19:02
 */
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = 5207865247400761539L;

    private Integer articleId;

    private Integer articleUserId;

    private String articleTitle;

    private Integer articleViewCount;

    private Integer articleCommentCount;

    private Integer articleLikeCount;

    private Date articleCreateTime;

    private Date articleUpdateTime;

    private Integer articleIsComment;

    private Integer articleStatus;

    private Integer articleOrder;

    private String articleContent;

    private String articleSummary;

    // 非数据库字段
    private Integer categoryId;

    private BlogUser blogUser;

    private List<BlogTag> tagList;

    private List<BlogCategory> categoryList;

    public Article() {
    }

    public Article(Integer articleId) {
        this.articleId = articleId;
        this.articleStatus = ArticleStatus.PUBLISH.getValue();
    }
}
