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
}
