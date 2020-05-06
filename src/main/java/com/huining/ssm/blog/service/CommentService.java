package com.huining.ssm.blog.service;

import com.github.pagehelper.PageInfo;
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
     * description:根据id获取评论
     * create time: 10:52 2020/5/6
     * @param id: 
     * @return: com.huining.ssm.blog.entity.BlogComment
     */
    BlogComment getCommentById(Integer id);
    /**
     * create by: huining
     * description:获取评论列表
     * create time: 16:30 2020/5/5
     * @param : 
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listComments();

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

    /**
     * create by: huining
     * description:分页查询评论
     * create time: 10:24 2020/5/6
     * @param pageIndex: 
 * @param pageSize: 
     * @return: com.github.pagehelper.PageInfo<com.huining.ssm.blog.entity.BlogComment>
     */
    PageInfo<BlogComment> listCommentByPage(Integer pageIndex, Integer pageSize);

    /**
     * create by: huining
     * description:根据评论pid查找子评论
     * create time: 14:30 2020/5/6
     * @param pid:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listChildComment(Integer pid);

    /**
     * create by: huining
     * description:批量删除评论
     * create time: 14:59 2020/5/6
     * @param commentList:
     * @return: void
     */
    void deleteComments(List<BlogComment> commentList);

    /**
     * create by: huining
     * description:
     * create time: 15:06 2020/5/6
     * @param comment: 
     * @return: void
     */
    void updateComment(BlogComment comment);
}
