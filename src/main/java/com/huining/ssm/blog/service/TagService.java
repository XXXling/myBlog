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

    /**
     * create by: huining
     * description:获得标签列表
     * create time: 16:49 2020/5/6
     
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogTag>
     */
    List<BlogTag> listTagWithCount();

    /**
     * create by: huining
     * description:新增标签
     * create time: 16:49 2020/5/6
     * @param tag: 
     * @return: void
     */
    void insertTag(BlogTag tag);

    /**
     * create by: huining
     * description:删除标签
     * create time: 16:56 2020/5/6
     * @param id: 
     * @return: void
     */
    void deleteTag(Integer id);

    /**
     * create by: huining
     * description:编辑标签
     * create time: 17:01 2020/5/6
     * @param tag: 
     * @return: void
     */
    void updateTag(BlogTag tag);
}
