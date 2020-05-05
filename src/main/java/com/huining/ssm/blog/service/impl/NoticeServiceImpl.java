package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.Notice;
import com.huining.ssm.blog.mapper.NoticeMapper;
import com.huining.ssm.blog.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> listNotice(Integer status) {
        return noticeMapper.listNotice(status);
    }

    @Override
    public Notice getNoticeById(Integer noticeId) {
        return noticeMapper.getNoticeById(noticeId);
    }
}
