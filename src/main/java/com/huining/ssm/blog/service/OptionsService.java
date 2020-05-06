package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogOptions;

/**
 * @Author: huining
 * @Date: 2020/4/24 14:27
 */
public interface OptionsService {

    /**
     * 获得基本信息
     *
     * @return 系统设置
     */
    BlogOptions getOptions();

    /**
     * create by: huining
     * description:新增基本信息
     * create time: 16:01 2020/5/6
     * @param options: 
     * @return: void
     */
    void insertOptions(BlogOptions options);

    /**
     * create by: huining
     * description:更新基本信息
     * create time: 16:04 2020/5/6
     * @param options:
     * @return: void
     */
    void updateOptions(BlogOptions options);
}
