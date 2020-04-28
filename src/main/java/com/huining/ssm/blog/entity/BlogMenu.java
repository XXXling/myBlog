package com.huining.ssm.blog.entity;

import lombok.Data;

/**
 * @Author: huining
 * @Date: 2020/4/20 17:43
 */
@Data
public class BlogMenu {
    private static final Long serialVersionUID = 489914127235951698L;
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private String menuLevel;
    private String menuIcon;
    private String menuOrder;
}
