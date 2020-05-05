package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/27 17:47
 */
@Mapper
public interface CommentMapper {
    /**
     * create by: huining
     * description:获取评论列表
     *
     * @param limit:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listComments(@Param("limit") Integer limit);

    /**
     * create by: huining
     * description:根据文章id查询评论
     *
     * @param articleId:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listCommentsByArticleId(@Param("limit") Integer articleId);

    /**
     * create by: huining
     * description:新增评论
     *
     * @param comment:
     * @return: void
     */
    void insertComment(BlogComment comment);

    /**
     * create by: huining
     * description:获取最新评论
     *
     * @param limit:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listRecentComment(@Param("limit") Integer limit);
}
