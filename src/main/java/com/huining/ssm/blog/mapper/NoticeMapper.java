package com.huining.ssm.blog.mapper;

import com.huining.ssm.blog.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    /**
     * create by: huining
     * description:根据状态查询公告
     * create time: 21:10 2020/5/5
     * @param status: 
     * @return: java.util.List<com.huining.ssm.blog.entity.Notice>
     */
    List<Notice> listNotice(@Param("status") Integer status);

    /**
     * create by: huining
     * description:根据id查询公告
     * create time: 21:07 2020/5/5
     * @param noticeId: 
     * @return: com.huining.ssm.blog.entity.Notice
     */
    Notice getNoticeById(@Param("noticeId") Integer noticeId);

    /**
     * create by: huining
     * description:新增公告
     * create time: 15:50 2020/5/6
     * @param notice:
     * @return: void
     */
    void insertNotice(Notice notice);

    /**
     * create by: huining
     * description:根据id删除公告
     * create time: 15:52 2020/5/6
     * @param id:
     * @return: void
     */
    void deleteNotice(@Param("id") Integer id);

    /**
     * create by: huining
     * description:更新公告
     * create time: 15:54 2020/5/6
     * @param notice:
     * @return: void
     */
    void updateNotice(Notice notice);
}
