package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 17:57
 */
@Mapper
public interface CategoryMapper {
    /**
     * create by: huining
     * description:查询所有分类
     * create time: 00:44 2020/5/6

     * @return: java.util.List<com.huining.ssm.blog.entity.BlogCategory>
     */
    List<BlogCategory> listCategory();

    /**
     * create by: huining
     * description:统计分类数量
     * create time: 00:43 2020/5/6

     * @return: java.lang.Integer
     */
    Integer countCategory();

    /**
     * create by: huining
     * description:根据文章id查询分类
     * create time: 00:45 2020/5/6
     * @param articleId:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogCategory>
     */
    List<BlogCategory> queryCatoryByArticleId(@Param("articleId") Integer articleId);

    /**
     * create by: huining
     * description:根据id查询分类
     * create time: 00:43 2020/5/6
     * @param cateId:
     * @return: com.huining.ssm.blog.entity.BlogCategory
     */
    BlogCategory getCategoryById(@Param("cateId") Integer cateId);

    /**
     * create by: huining
     * description:新增分类
     * create time: 00:43 2020/5/6
     * @param category:
     * @return: void
     */
    void insert(BlogCategory category);

    /**
     * create by: huining
     * description:根据id删除
     * create time: 00:55 2020/5/6
     * @param id:
     * @return: void
     */
    void delete(@Param("categoryId") Integer id);

    /**
     * create by: huining
     * description:更新分类
     * create time: 01:10 2020/5/6
     * @param category:
     * @return: void
     */
    void updateCategory(BlogCategory category);
}
