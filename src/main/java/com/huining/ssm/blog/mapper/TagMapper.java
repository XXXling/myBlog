package com.huining.ssm.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: huining
 * @Date: 2020/4/23 14:38
 */
@Mapper
public interface TagMapper {
    Integer countTag();
}
