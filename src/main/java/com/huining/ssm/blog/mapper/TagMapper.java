package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogTag;
import com.huining.ssm.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/23 14:38
 */
@Mapper
public interface TagMapper {
    /**
     * create by: huining
     * description:统计标签数目
     * create time: 16:54 2020/5/6

     * @return: java.lang.Integer
     */
    Integer countTag();

    /**
     * create by: huining
     * description:获取标签列表
     * create time: 16:51 2020/5/6

     * @return: java.util.List<com.huining.ssm.blog.entity.BlogTag>
     */
    List<BlogTag> listTag();

    /**
     * create by: huining
     * description:根据id获取标签
     * create time: 16:50 2020/5/6
     * @param tagId:
     * @return: com.huining.ssm.blog.entity.BlogTag
     */
    BlogTag getTagById(@Param("tagId") Integer tagId);

    /**
     * create by: huining
     * description:新增标签
     * create time: 16:50 2020/5/6
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
    void deleteTag(@Param("id") Integer id);

    /**
     * create by: huining
     * description:更新标签
     * create time: 16:59 2020/5/6
     * @param tag:
     * @return: void
     */
    void updateTag(BlogTag tag);
}
