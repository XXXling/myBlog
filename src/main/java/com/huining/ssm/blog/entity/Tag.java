package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: huining
 * @Date: 2020/4/24 13:35
 */
@Data
public class Tag implements Serializable {
    public Integer tagId;
    public String tagName;
    public String tagDescription;

    /**
     * 文章数量(不是数据库字段)
     */
    private Integer articleCount;

    public Tag() {
    }

    public Tag(Integer tagId) {
        this.tagId = tagId;
    }

    public Tag(Integer tagId, String tagName, String tagDescription, Integer articleCount) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
        this.articleCount = articleCount;
    }
}
