package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.ArticleTagRef;
import com.huining.ssm.blog.entity.BlogTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/6 00:12
 */
@Mapper
public interface ArticleTagRefMapper {
    /**
     * create by: huining
     * description:批量插入文章与标签关联数据
     * create time: 00:23 2020/5/6
     * @param articleTagRefs:
     * @return: void
     */
    void insert(@Param("articleTagRefs") List<ArticleTagRef> articleTagRefs);

    /**
     * create by: huining
     * description:根据标签id删除
     * create time: 14:40 2020/5/6
     * @param tags:
     * @return: void
     */
    void deleteByTagId(@Param("tags") List<BlogTag> tags);

    void deleteByTagIdSingle(@Param("tagId") Integer tagId);

    /**
     * create by: huining
     * description:根据标签id统计标签下文章数目
     * create time: 16:46 2020/5/6
     * @param tagId:
     * @return: java.lang.Integer
     */
    Integer countArticleByTagId(@Param("tagId") Integer tagId);

    /**
     * create by: huining
     * description:根据articleId查询所有标签
     * create time: 03:11 2020/5/7
     * @param articleId:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogTag>
     */
    List<BlogTag> listTagByArticleId(@Param("articleId") Integer articleId);
}
