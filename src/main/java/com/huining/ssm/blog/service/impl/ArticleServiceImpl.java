package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.mapper.ArticleMapper;
import com.huining.ssm.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 18:52
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = false)
    private ArticleMapper articleMapper;

    @Override
    public Integer countArticle(Integer status) {
        Integer count = 0;

        try {
            count = articleMapper.countArticle(status);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取文章总数失败，status:{},cause:{}", status, e);
        }
        return count;
    }

    @Override
    public Integer countArticleComment() {
        Integer count = null;
        try {
            count = articleMapper.countArticleComment();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取文章留言总数失败，cause:{}", e);
        }
        return count;
    }

    @Override
    public Integer countArticleView() {
        Integer count = null;
        try {
            count = articleMapper.countArticleView();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取文章浏览总数失败，cause:{}", e);
        }
        return count;
    }

    /**
     * 获取最后更新的文章
     *
     * @return Article
     */
    @Override
    public Article getLastUpdateArticle() {
        Article lasArticle = null;
        try {
            lasArticle = articleMapper.getLasUupdateArticle();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取最后更新的文章失败，cause:{}",e);
        }
        return lasArticle;
    }

    @Override
    public List<Article> listArticle(Integer limit) {
        List<Article> articles = null;
        try {
            articles = articleMapper.listArticleByLimit(limit);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取文章列表失败，cause:{}",e);
        }
        return articles;
    }
}
