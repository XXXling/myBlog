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
     * @param
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listComments();

    /**
     * create by: huining
     * description:根据文章id查询评论
     *
     * @param articleId:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listCommentsByArticleId(@Param("articleId") Integer articleId);

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

    /**
     * create by: huining
     * description:根据id获得评论
     * create time: 10:53 2020/5/6
     * @param id:
     * @return: com.huining.ssm.blog.entity.BlogComment
     */
    BlogComment getCommentById(@Param("commentId") Integer id);

    /**
     * create by: huining
     * description:删除评论
     * create time: 10:56 2020/5/6
     * @param id:
     * @return: void
     */
    void deleteComment(@Param("commentId")Integer id);

    /**
     * create by: huining
     * description:批量删除评论
     * create time: 11:04 2020/5/6
     * @param comments:
     * @return: void
     */
    void deleteComments(@Param("comments")List<BlogComment> comments);

    /**
     * create by: huining
     * description:根据id查找子评论
     * create time: 11:05 2020/5/6
     * @param pid:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogComment>
     */
    List<BlogComment> listChildComment(@Param("pid") Integer pid);

    /**
     * create by: huining
     * description:更新评论
     * create time: 15:20 2020/5/6
     * @param comment: 
     * @return: void
     */
    void update(BlogComment comment);
}
