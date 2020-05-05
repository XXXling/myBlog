package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogComment;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/24 15:45
 */
public interface CommentService {
    
    /**
     * create by: huining
     * description:获取评论列表
     * create time: 16:30 2020/5/5
     * @param limit: 
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listComments(Integer limit);

    /**
     * create by: huining
     * description:根据文章id获取评论列表
     * create time: 16:48 2020/5/5
     * @param articleId: 
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listCommentsByArticleId(Integer articleId);

    /**
     * create by: huining
     * description:增加评论
     * create time: 16:29 2020/5/5
     * @param comment: 
     * @return: void
     */
    void insertComment(BlogComment comment);

    /**
     * create by: huining
     * description:获得最近评论
     * create time: 17:36 2020/5/5
     * @param limit:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listRecentComment(Integer limit);
}
