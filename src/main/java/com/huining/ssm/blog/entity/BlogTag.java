package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: huining
 * @Date: 2020/4/21 19:05
 */
@Data
public class BlogTag implements Serializable {
    public Integer tagId;
    public String tagName;
    public String tagDescription;

    /**
     * 文章数量(不是数据库字段)
     */
    private Integer articleCount;

    public BlogTag() {
    }

    public BlogTag(Integer tagId) {
        this.tagId = tagId;
    }

    public BlogTag(Integer tagId, String tagName, String tagDescription, Integer articleCount) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
        this.articleCount = articleCount;
    }
}
