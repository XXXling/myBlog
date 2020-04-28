package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogComment;
import com.huining.ssm.blog.mapper.CommentMapper;
import com.huining.ssm.blog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/24 16:53
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<BlogComment> listComments(Integer limit) {
        return commentMapper.listComments(limit);
    }
}
