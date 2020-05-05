package com.huining.ssm.blog.service;

import com.huining.ssm.blog.entity.Notice;

import java.util.List;

public interface NoticeService {
    /**
     * create by: huining
     * description:获得公告列表
     * create time: 17:27 2020/5/5
     * @param status: 
     * @return: java.util.List<com.huining.ssm.blog.entity.Notice>
     */
    List<Notice> listNotice(Integer status);

    /**
     * create by: huining
     * description:公告内容和信息显示
     * create time: 21:04 2020/5/5
     * @param noticeId:
     * @return: com.huining.ssm.blog.entity.Notice
     */
    Notice getNoticeById(Integer noticeId);
}
