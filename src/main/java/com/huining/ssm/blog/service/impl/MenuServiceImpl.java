package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogMenu;
import com.huining.ssm.blog.mapper.MenuMapper;
import com.huining.ssm.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/20 17:51
 */
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired(required = false)
    private MenuMapper menuMapper;

    @Override
    public List<BlogMenu> listMenu() {
        return menuMapper.listMenu();
    }

    @Override
    public BlogMenu addMenu(BlogMenu menu){
        int response = menuMapper.insterMenu(menu);
        return menu;
    }

    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteMenu(id);
    }

    @Override
    public void updateMenu(BlogMenu menu) {
        menuMapper.updateMenu(menu);
    }

    @Override
    public BlogMenu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }
}
