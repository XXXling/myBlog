package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogMenu;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/20 17:40
 */
public interface MenuService{
    /**
     * 获取菜单列表
     */
    List<BlogMenu> listMenu();

    /**
     *添加菜单项目
     * @param menu
     * @return
     */
    BlogMenu addMenu(BlogMenu menu);

    /**
     * 删除菜单项目
     * @param id
     */
    void deleteMenu(Integer id);

    /**
     * 更新菜单项目
     * @param menu
     */
    void updateMenu(BlogMenu menu);

    /**
     * 根据id获得菜单项目信息
     * @param id
     * @return
     */
    BlogMenu findMenuById(Integer id);
}
