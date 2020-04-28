package com.huining.ssm.blog.enums;

import sun.util.resources.cldr.fr.CalendarData_fr_TD;

/**
 * @Author: huining
 * @Date: 2020/4/21 18:35
 */
public enum ArticleStatus {
    PUBLISH(1, "已发布"),
    DARFT(0, "草稿");

    private Integer value;
    private String message;

    ArticleStatus(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
