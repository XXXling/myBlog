package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogTag;
import com.huining.ssm.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/23 14:38
 */
@Mapper
public interface TagMapper {
    Integer countTag();

    List<BlogTag> listTag();

    BlogTag getTagById(@Param("tagId") Integer tagId);
}
