package com.huining.ssm.blog.service.impl;

import com.huining.ssm.blog.entity.BlogTag;
import com.huining.ssm.blog.entity.Tag;
import com.huining.ssm.blog.mapper.ArticleTagRefMapper;
import com.huining.ssm.blog.mapper.TagMapper;
import com.huining.ssm.blog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/23 14:31
 */
@Service
@Slf4j
public class TagServiceImpl implements TagService {

    @Autowired(required = false)
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;

    @Override
    public Integer countTag() {
        return tagMapper.countTag();
    }

    @Override
    public List<BlogTag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public BlogTag getTagById(Integer tagId) {
        return tagMapper.getTagById(tagId);
    }

    @Override
    public List<BlogTag> listTagWithCount() {
        List<BlogTag> tags = null;
        try {
            tags = tagMapper.listTag();
            for (BlogTag tag : tags) {
                Integer count = articleTagRefMapper.countArticleByTagId(tag.getTagId());
                tag.setArticleCount(count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获得所有标签失败, cause:{}", e);
        }
        return tags;
    }

    @Override
    public void insertTag(BlogTag tag) {
        tagMapper.insertTag(tag);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTag(Integer id) {
        try {
            tagMapper.deleteTag(id);
            articleTagRefMapper.deleteByTagIdSingle(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTag(BlogTag tag) {
        tagMapper.updateTag(tag);
    }
}
