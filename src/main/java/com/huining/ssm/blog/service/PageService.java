package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogPage;

import java.util.List;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/5 21:29
 */
public interface PageService {
    /**
     * create by: huining
     * description:根据页面key获得页面
     * create time: 16:07 2020/5/6
     * @param status:
 * @param key:
     * @return: com.huining.ssm.blog.entity.BlogPage
     */
    BlogPage getPageByKey(Integer status, String key);

    /**
     * create by: huining
     * description:获得页面列表
     * create time: 16:05 2020/5/6
     * @param status:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogPage>
     */
    List<BlogPage> listPage(Integer status);

    /**
     * 根据id获取页面
     *
     * @param id 页面ID
     * @return 页面
     */
    BlogPage getPageById(Integer id);

    /**
     * 添加页面
     *
     * @param page 页面
     */
    void insertPage(BlogPage page);

    /**
     * 删除页面
     *
     * @param id 页面ID
     */
    void deletePage(Integer id);

    /**
     * 编辑页面
     *
     * @param page 分页
     */
    void updatePage(BlogPage page);
}
