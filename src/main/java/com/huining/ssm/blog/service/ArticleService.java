package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.Article;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 18:35
 */
public interface ArticleService {

    /**
     * 获取文章总数
     *
     * @param status
     * @return
     */
    Integer countArticle(Integer status);

    /**
     * 获取评论总数
     *
     * @return
     */
    Integer countArticleComment();

    /**
     * 获得浏览量总数
     *
     * @return 数量
     */
    Integer countArticleView();

    /**
     * 获取最后更新的文章
     *
     * @return Article
     */
    Article getLastUpdateArticle();

    /**
     * 获取文章列表
     * @param limit
     * @return
     */
    List<Article> listArticle(Integer limit);
}
