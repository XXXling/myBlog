package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogLink;
import com.huining.ssm.blog.mapper.LinkMapper;
import com.huining.ssm.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/24 13:41
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired(required = false)
    private LinkMapper linkMapper;

    /**
     * 获得链接总数
     *
     * @param status 状态
     * @return 数量
     */
    @Override
    public Integer countLink(Integer status) {
        return linkMapper.countLink(status);
    }

    @Override
    public void insertLink(BlogLink link) {
        linkMapper.insertLink(link);
    }

    @Override
    public BlogLink getLinkById(Integer id) {
        return linkMapper.getLinkById(id);
    }

    @Override
    public List<BlogLink> listLink(Integer status) {
        return linkMapper.listLink(status);
    }

    @Override
    public void deleteLink(Integer id) {
        linkMapper.deleteLink(id);
    }

    @Override
    public void updateLink(BlogLink link) {
        linkMapper.updateLink(link);
    }
}
