package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: huining
 * @Date: 2020/4/24 14:26
 */
@Data
public class BlogOptions implements Serializable {
    private static final long serialVersionUID = -776792869602511933L;
    private Integer optionId;

    private String optionSiteTitle;

    private String optionSiteDescrption;

    private String optionMetaDescrption;

    private String optionMetaKeyword;

    private String optionAboutsiteAvatar;

    private String optionAboutsiteTitle;

    private String optionAboutsiteContent;

    private String optionAboutsiteWechat;

    private String optionAboutsiteQq;

    private String optionAboutsiteGithub;

    private String optionAboutsiteWeibo;

    private String optionTongji;

    private Integer optionStatus;
}
