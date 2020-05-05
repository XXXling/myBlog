package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/5 21:28
 */
@Data
public class BlogPage implements Serializable {

    private static final long serialVersionUID = 3927496662110298634L;
    private Integer pageId;

    private String pageKey;

    private String pageTitle;

    private String pageContent;

    private Date pageCreateTime;

    private Date pageUpdateTime;

    private Integer pageViewCount;

    private Integer pageCommentCount;

    private Integer pageStatus;
}
