package com.huining.ssm.blog.mapper;

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
     * @param articleId: 
     * @param tagList:
     * @return: void
     */
    void insert(@Param("articleId") Integer articleId, @Param("tags") List<BlogTag> tagList);
}
