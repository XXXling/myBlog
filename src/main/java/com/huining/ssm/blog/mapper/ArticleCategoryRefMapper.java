package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.ArticleCategoryRef;
import com.huining.ssm.blog.entity.BlogCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleCategoryRefMapper {

   /**
    * create by: huining
    * description:根据文章ID获得分类列表
    * create time: 15:15 2020/5/5
    * @param articleId: 
    * @return: java.util.List<com.huining.ssm.blog.entity.BlogCategory>
    */
    List<BlogCategory> listCategoryByArticleId(@Param("articleId") Integer articleId);

    /**
     * create by: huining
     * description:根据分类id查询分类文章总数
     * create time: 00:02 2020/5/6
     * @param categoryId:
     * @return: java.lang.Integer
     */
    Integer countArticleByCategoryId(@Param("categoryId") Integer categoryId);

    /**
     * create by: huining
     * description:批量插入文章与分类关联数据
     * create time: 00:21 2020/5/6
     * @param articleId: 
     * @param categorys:
     * @return: void
     */
    void insert(@Param("articleId") Integer articleId,@Param("categorys") List<BlogCategory> categorys);

    /**
     * create by: huining
     * description:根据分类id删除
     * create time: 00:57 2020/5/6
     * @param categoryId:
     * @return: void
     */
    void deleteByCategoryId(@Param("categoryId") Integer categoryId);
}
