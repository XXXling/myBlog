package com.huining.ssm.blog.controller.home;

import com.github.pagehelper.PageInfo;
import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogTag;
import com.huining.ssm.blog.enums.ArticleStatus;
import com.huining.ssm.blog.service.ArticleService;
import com.huining.ssm.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/5 21:39
 */
@Controller
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;

    /**
     * 根据标签查询文章
     *
     * @param tagId 标签ID
     * @return 模板
     */
    @RequestMapping("/tag/{tagId}")
    public String getArticleListByTag(@PathVariable("tagId") Integer tagId,
                                      @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                      Model model) {
        //该标签信息
        BlogTag tag = tagService.getTagById(tagId);
        if (tag == null) {
            return "redirect:/404";
        }
        model.addAttribute("tag", tag);

        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("tagId", tagId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);

        //侧边栏
        //标签列表显示
        List<BlogTag> allTagList = tagService.listTag();
        model.addAttribute("allTagList", allTagList);
        //获得随机文章
        List<Article> randomArticleList = articleService.listRandomArticle();
        model.addAttribute("randomArticleList", randomArticleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount();
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        model.addAttribute("pageUrlPrefix", "/tag?pageIndex");
        return "Home/Page/articleListByTag";
    }
}
