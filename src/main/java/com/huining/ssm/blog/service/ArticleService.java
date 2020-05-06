package com.huining.ssm.blog.service;

import com.github.pagehelper.PageInfo;
import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogCategory;

import java.util.HashMap;
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


    /**
     * create by: huining
     * description:获取文章详情
     * create time: 17:16 2020/5/3
     * @param value:
     * @param articleId:
     * @return: com.huining.ssm.blog.entity.Article
     */
    Article getArticleDetails(Integer value, Integer articleId);

     /**
      * create by: huining
      * description:查询相关文章
      * create time: 11:45 2020/5/3
      * @param articleId:
      * @return: java.util.List<com.huining.ssm.blog.entity.Article>
      */
    List<Article> listAboutArticle(Integer articleId);

    /**
     * create by: huining
     * description:猜你喜欢
     * create time: 11:43 2020/5/3

     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listArticleByViewCount();

    /**
     * create by: huining
     * description:获取上一篇文章
     * create time: 12:04 2020/5/3
     * @param articleId: 
     * @return: com.huining.ssm.blog.entity.Article
     */
    Article getAfterArticle(Integer articleId);

    /**
     * create by: huining
     * description:获取下一篇文章
     * create time: 12:18 2020/5/3
     * @param articleId: 
     * @return: com.huining.ssm.blog.entity.Article
     */
    Article getPreArticle(Integer articleId);

    /**
     * create by: huining
     * description:获得随机随机文章
     * create time: 12:28 2020/5/3
     * @param articleId: 
     * @return: com.huining.ssm.blog.entity.Article
     */
    List<Article> listRandomArticle(Integer articleId);

    List<Article> listRandomArticle();

    /**
     * create by: huining
     * description:获得热评文章
     * create time: 12:32 2020/5/3
     * @param articleId: 
     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listArticleByCommentCount(Integer articleId);

    List<Article> listArticleByCommentCount();

    /**
     * create by: huining
     * description:点赞数增加
     * create time: 17:03 2020/5/3
     * @param id: 
     * @return: java.lang.Integer
     */
    Integer increaseLikeCount(Integer id);

    /**
     * create by: huining
     * description:浏览数增加
     * create time: 17:05 2020/5/3
     * @param id: 
     * @return: java.lang.Integer
     */
    Integer increaseViewCount(Integer id);



    /**
     * create by: huining
     * description:分页查询文章
     * create time: 13:51 2020/5/5
     * @param criteria:
     * @return: com.github.pagehelper.PageInfo<com.huining.ssm.blog.entity.Article>
     */
    PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, HashMap<String, Object> criteria);

    /**
     * create by: huining
     * description:更新文章评论总数
     * create time: 16:34 2020/5/5
     * @param commentArticleId: 
     * @return: void
     */
    void updateCommentCount(Integer commentArticleId);

    /**
     * create by: huining
     * description:查询所有文章
     * create time: 21:38 2020/5/5

     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    List<Article> listAllNotWithContent();

    /**
     * create by: huining
     * description:添加文章
     * create time: 23:10 2020/5/5
     * @param article: 
     * @return: void
     */
    void insertArticle(Article article);

    /**
     * create by: huining
     * description:根据id删除文章
     * create time: 23:23 2020/5/5
     * @param id:
     * @return: void
     */
    void deleteArticleById(Integer id);

    /**
     * create by: huining
     * description:批量删除文章
     * create time: 23:43 2020/5/5
     * @param id:
     * @return: void
     */
    void deleteArticleBatch(List<Integer> id);

    /**
     * create by: huining
     * description:更新文章及其关联信息
     * create time: 00:01 2020/5/6
     * @param article: 
     * @return: void
     */
    void updateArticleDetail(Article article);

    /**
     * create by: huining
     * description:更新文章
     * create time: 15:14 2020/5/6
     * @param article:
     * @return: void
     */
    void updateArticle(Article article);

    /**
     * create by: huining
     * description:查询该分类有多少文章
     * create time: 01:00 2020/5/6
     * @param id: 
     * @return: int
     */
    int countArticleByCategoryId(Integer id);

    /**
     * create by: huining
     * description:查询该标签有多少文章
     * create time: 17:06 2020/5/6
     * @param id: 
     * @return: java.lang.Integer
     */
    Integer countArticleByTagId(Integer id);
}
