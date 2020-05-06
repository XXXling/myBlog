package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogPage;
import com.huining.ssm.blog.mapper.PageMapper;
import com.huining.ssm.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/6 16:06
 */
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageMapper pageMapper;

    @Override
    public BlogPage getPageByKey(Integer status, String key) {
        return pageMapper.getPageByKey(status,key);
    }

    @Override
    public List<BlogPage> listPage(Integer status) {
        return pageMapper.listPage(status);
    }

    @Override
    public BlogPage getPageById(Integer id) {
        return pageMapper.getPageById(id);
    }

    @Override
    public void insertPage(BlogPage page) {
        pageMapper.insertPage(page);
    }

    @Override
    public void deletePage(Integer id) {
        pageMapper.deleteById(id);
    }

    @Override
    public void updatePage(BlogPage page) {
        pageMapper.updatePage(page);
    }
}
