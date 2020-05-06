package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.BlogPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/6 16:08
 */
@Mapper
public interface PageMapper {
    /**
     * create by: huining
     * description:根据key获得页面
     * create time: 16:12 2020/5/6
     * @param status:
 * @param key:
     * @return: com.huining.ssm.blog.entity.BlogPage
     */
    BlogPage getPageByKey(@Param("status")Integer status,@Param("key") String key);

    /**
     * create by: huining
     * description:根据状态获得页面
     * create time: 16:12 2020/5/6
     * @param status:
     * @return: java.util.List<com.huining.ssm.blog.entity.BlogPage>
     */
    List<BlogPage> listPage(@Param("status")Integer status);

    /**
     * create by: huining
     * description:根据id获得页面
     * create time: 16:13 2020/5/6
     * @param id:
     * @return: com.huining.ssm.blog.entity.BlogPage
     */
    BlogPage getPageById(@Param("id")Integer id);

    /**
     * create by: huining
     * description:新增页面
     * create time: 16:13 2020/5/6
     * @param page:
     * @return: void
     */
    void insertPage(BlogPage page);

    /**
     * create by: huining
     * description:删除页面
     * create time: 16:13 2020/5/6
     * @param id:
     * @return: void
     */
    void deleteById(@Param("id") Integer id);

    /**
     * create by: huining
     * description:更新页面
     * create time: 16:14 2020/5/6
     * @param page:
     * @return: void
     */
    void updatePage(BlogPage page);

}
