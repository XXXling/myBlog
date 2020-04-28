package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/27 17:47
 */
@Mapper
public interface CommentMapper {
    List<BlogComment> listComments(@Param("limit") Integer limit);
}
