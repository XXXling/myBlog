package com.huining.ssm.blog.service.impl;

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
    public List<BlogComment> listComments(Integer limit) {
        return commentMapper.listComments(limit);
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


}
