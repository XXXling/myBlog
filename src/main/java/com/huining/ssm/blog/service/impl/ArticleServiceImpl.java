package com.huining.ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huining.ssm.blog.entity.*;
import com.huining.ssm.blog.enums.ArticleCommentStatus;
import com.huining.ssm.blog.mapper.ArticleCategoryRefMapper;
import com.huining.ssm.blog.mapper.ArticleMapper;
import com.huining.ssm.blog.mapper.ArticleTagRefMapper;
import com.huining.ssm.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private ArticleCategoryRefMapper articleCategoryRefMapper;

    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;

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

    @Override
    public Article getArticleDetails(Integer value, Integer articleId) {
        Article param =new Article();
        if (value != null) {
            param.setArticleStatus(value);
        }
        param.setArticleId(articleId);
        return articleMapper.findArticle(param);
    }

    @Override
    public List<Article> listAboutArticle(Integer articleId) {
        List<Article> articles = articleMapper.listAboutArticle(articleId);
        return articles;
    }

    /**
     * create by: huining
     * description:猜你喜欢
     * create time: 12:02 2020/5/3
     
     * @return: java.util.List<com.huining.ssm.blog.entity.Article>
     */
    @Override
    public List<Article> listArticleByViewCount() {
        List<Article> articles = null;
        try {
            articles = articleMapper.listArticleByViewCount();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取猜你喜欢失败，cause:{}",e);
        }
        return articles;
    }

    @Override
    public Article getAfterArticle(Integer articleId) {
        Article afterArticle = null;
        try {
            afterArticle = articleMapper.getAfterArticle(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取上一篇文章失败，cause:{}",e);
        }
        return afterArticle;
    }

    @Override
    public Article getPreArticle(Integer articleId) {
        Article preArticle = null;
        try {
            preArticle = articleMapper.getPreArticle(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取下一篇文章失败，cause:{}",e);
        }
        return preArticle;
    }

    @Override
    public List<Article> listRandomArticle(Integer articleId) {
        List<Article> randomArticle = null;
        try {
            randomArticle = articleMapper.listRandomArticle(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取随机文章失败，cause:{}",e);
        }
        return randomArticle;
    }

    @Override
    public List<Article> listRandomArticle() {
        List<Article> randomArticle = null;
        try {
            randomArticle = articleMapper.listRandomArticle2();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取随机文章失败，cause:{}",e);
        }
        return randomArticle;
    }

    @Override
    public List<Article> listArticleByCommentCount(Integer articleId) {
        List<Article> mostArticleList = null;
        try {
            mostArticleList = articleMapper.listMostArticle(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取热评文章失败，cause:{}",e);
        }
        return mostArticleList;
    }

    @Override
    public List<Article> listArticleByCommentCount() {
        List<Article> mostArticleList = null;
        try {
            mostArticleList = articleMapper.listMostArticle2();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取热评文章失败，cause:{}",e);
        }
        return mostArticleList;
    }

    @Override
    public Integer increaseLikeCount(Integer id) {
        articleMapper.increaseLikeCount(id);
        Article article = articleMapper.findArticle(new Article(id));
        return article.getArticleLikeCount();
    }

    @Override
    public Integer increaseViewCount(Integer id) {
        articleMapper.increaseViewCount(id);
        return null;
    }

    @Override
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, HashMap<String, Object> criteria) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Article> articles = articleMapper.queryArticle(criteria);
        for (Article article : articles) {
            List<BlogCategory> categorys = articleCategoryRefMapper.listCategoryByArticleId(article.getArticleId());
            if (categorys == null || categorys.size() == 0){
                categorys = new ArrayList<>();
                categorys.add(BlogCategory.Default());
            }
            article.setCategoryList(categorys);
        }
        return null;
    }

    @Override
    public void updateCommentCount(Integer commentArticleId) {
        articleMapper.updateCommentCount(commentArticleId);
    }

    @Override
    public List<Article> listAllNotWithContent() {
        return articleMapper.listAllNotWithContent();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertArticle(Article article) {
        //添加文章
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleIsComment(ArticleCommentStatus.ALLOW.getValue());
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);
        article.setArticleOrder(1);
        articleMapper.insertArticle(article);

        //添加分类和文章关联
        articleCategoryRefMapper.insert(article.getArticleId(),article.getCategoryList());
        //添加标签和文章关联
        articleTagRefMapper.insert(article.getArticleId(),article.getTagList());
    }

    @Override
    public void deleteArticleById(Integer id) {
        articleMapper.deleteById(id);
    }

    @Override
    public void deleteArticleBatch(List<Integer> ids) {
        articleMapper.deleteBatch(ids);
    }

    @Override
    public void updateArticleDetail(Article article) {
        articleMapper.updateArticleDetail(article);
    }

    @Override
    public int countArticleByCategoryId(Integer id) {
        return articleCategoryRefMapper.countArticleByCategoryId(id);
    }


}
