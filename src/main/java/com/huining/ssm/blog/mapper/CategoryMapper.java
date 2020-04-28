package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 17:57
 */
@Mapper
public interface CategoryMapper {
    List<BlogCategory> listCategory();

    Integer countCategory();
}
