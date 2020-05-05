package com.huining.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: huining
 * @Date: 2020/4/24 13:47
 */
@Data
public class BlogLink implements Serializable {
    private static final long serialVersionUID = -259829372268790508L;

    private Integer linkId;

    private String linkUrl;

    private String linkName;

    private String linkImage;

    private String linkDescription;

    private String linkOwnerNickname;

    private String linkOwnerContact;

    private Date linkUpdateTime;

    private Date linkCreateTime;

    private Integer linkOrder;

    private Integer linkStatus;
}
