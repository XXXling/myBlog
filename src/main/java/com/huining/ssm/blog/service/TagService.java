package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.BlogTag;
import com.huining.ssm.blog.entity.Tag;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/21 18:45
 */
public interface TagService {
    /**
     * 获得标签总数
     *
     * @return 数量
     */
    Integer countTag();

    /**
     * create by: huining
     * description:获得标签列表
     * create time: 17:26 2020/5/3
     
     * @return: java.util.List<com.huining.ssm.blog.entity.Tag>
     */
    List<BlogTag> listTag();

    /**
     * create by: huining
     * description:根据id获取标签列表
     * create time: 21:41 2020/5/5
     * @param tagId:
     * @return: com.huining.ssm.blog.entity.BlogTag
     */
    BlogTag getTagById(Integer tagId);
}
