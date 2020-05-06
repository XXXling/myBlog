package com.huining.ssm.blog.entity;

import lombok.Data;

/**
 * @Author: huining
 * @Date: 2020/4/20 17:43
 */
@Data
public class BlogMenu {
    private static final long serialVersionUID = 489914127235951698L;
    private Integer menuId;

    private String menuName;

    private String menuUrl;

    private Integer menuLevel;

    private String menuIcon;

    private Integer menuOrder;
}
