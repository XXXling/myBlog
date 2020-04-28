package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/20 17:52
 */
@Mapper
public interface MenuMapper {
    List<BlogMenu> listMenu();

    int insterMenu(BlogMenu menu);

    int deleteMenu(Integer id);

    int updateMenu(BlogMenu menu);

    BlogMenu findMenuById(Integer id);
}
