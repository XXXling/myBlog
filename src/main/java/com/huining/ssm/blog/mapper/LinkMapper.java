package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: huining
 * @Date: 2020/4/24 13:42
 */
@Mapper
public interface LinkMapper {
    Integer countLink(@Param("status") Integer status);

    void insertLink(BlogLink link);
}
