package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.mapper.TagMapper;
import com.huining.ssm.blog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: huining
 * @Date: 2020/4/23 14:31
 */
@Service
@Slf4j
public class TagServiceImpl implements TagService {

    @Autowired(required = false)
    private TagMapper tagMapper;

    @Override
    public Integer countTag() {
        return tagMapper.countTag();
    }
}
