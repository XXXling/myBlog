package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogComment;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/24 15:45
 */
public interface CommentService {
    List<BlogComment> listComments(Integer limit);
}
