package com.huining.ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogComment;
import com.huining.ssm.blog.enums.ArticleStatus;
import com.huining.ssm.blog.mapper.CommentMapper;
import com.huining.ssm.blog.service.ArticleService;
import com.huining.ssm.blog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/24 16:53
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public BlogComment getCommentById(Integer id) {
        return commentMapper.getCommentById(id);
    }

    @Override
    public List<BlogComment> listComments() {
        return commentMapper.listComments();
    }

    @Override
    public List<BlogComment> listCommentsByArticleId(Integer articleId) {
        return commentMapper.listCommentsByArticleId(articleId);
    }

    @Override
    public void insertComment(BlogComment comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public List<BlogComment> listRecentComment(Integer limit) {
        List<BlogComment> comments = null;
        try {
            comments = commentMapper.listRecentComment(limit);
            for (BlogComment comment : comments) {
                Article articleDetails = articleService.getArticleDetails(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
                comment.setArticle(articleDetails);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取最近评论失败，cause:{}",e);
        }
        return comments;
    }

    @Override
    public PageInfo<BlogComment> listCommentByPage(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<BlogComment> comments = null;
        try {
            comments = commentMapper.listComments();
            for (BlogComment comment : comments) {
                Article article = articleService.getArticleDetails(ArticleStatus.PUBLISH.getValue(),comment.getCommentArticleId());
                comment.setArticle(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("分页获得评论失败,pageIndex:{}, pageSize:{}, cause:{}", pageIndex, pageSize, e);
        }
        return new PageInfo<>(comments);
    }

    @Override
    public List<BlogComment> listChildComment(Integer pid) {
        return commentMapper.listChildComment(pid);
    }

    @Override
    public void deleteComments(List<BlogComment> commentList) {
        commentMapper.deleteComments(commentList);
    }

    @Override
    public void updateComment(BlogComment comment) {
        commentMapper.update(comment);
    }


}
