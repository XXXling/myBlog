package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogPage;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/5 21:29
 */
public interface PageService {

    BlogPage getPageByKey(int i, String key);
}
