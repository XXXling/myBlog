package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogOptions;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: huining
 * @Date: 2020/4/24 14:31
 */
@Mapper
public interface OptionsMapper {
    BlogOptions getOptions();

    void insertOptions(BlogOptions options);

    void updateOptions(BlogOptions options);
}
