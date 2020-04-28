package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 18:53
 */
@Mapper
public interface ArticleMapper {
    /**
     * 获得最新文章
     *
     * @param limit 查询数量
     * @return 列表
     */
    List<Article> listArticleByLimit(@Param("limit")Integer limit);

    Integer countArticle(@Param("status") Integer status);

    Integer countArticleComment();

    Integer countArticleView();

    Article getLasUupdateArticle();
}
