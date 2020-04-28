package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogOptions;
import com.huining.ssm.blog.mapper.OptionsMapper;
import com.huining.ssm.blog.service.OptionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: huining
 * @Date: 2020/4/24 14:28
 */
@Service
@Slf4j
public class OptionsServiceImpl implements OptionsService {
    @Autowired(required = false)
    private OptionsMapper optionsMapper;

    @Override
    public BlogOptions getOptions() {
        BlogOptions options = null;
        try {
            options = optionsMapper.getOptions();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取博客基本信息失败，cause:{}");
        }
        return options;
    }
}
