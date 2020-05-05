package com.huining.ssm.blog.controller.home;

import com.alibaba.fastjson.JSON;
import com.huining.ssm.blog.entity.*;
import com.huining.ssm.blog.enums.ArticleStatus;
import com.huining.ssm.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/28 17:20
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;



    /**
     * 文章详情页显示
     *
     * @param articleId 文章ID
     * @return modelAndView
     */
    @RequestMapping(value = "/article/{articleId}")
    public String getArticleDetailPage(@PathVariable("articleId") Integer articleId, Model model) {

        //文章信息，分类，标签，作者，评论
        Article article = articleService.getArticleDetails(ArticleStatus.PUBLISH.getValue(),articleId);
        if (article == null) {
            return "Home/Error/404";
        }

        //用户信息
        BlogUser author = userService.queryUser(new BlogUser(article.getArticleUserId()));
        article.setBlogUser(author);

        model.addAttribute("article",article);

        //评论列表
        List<BlogComment> comments = commentService.listCommentsByArticleId(articleId);
        model.addAttribute("commentList",comments);

        //相关文章
        List<Article> similarArticleList = articleService.listAboutArticle(articleId);
        model.addAttribute("similarArticleList", similarArticleList);

        //猜你喜欢
        List<Article> mostViewArticleList = articleService.listArticleByViewCount();
        model.addAttribute("mostViewArticleList", mostViewArticleList);

        //获取下一篇文章
        Article afterArticle = articleService.getAfterArticle(articleId);
        //获取上一篇文章
        Article preArticle = articleService.getPreArticle(articleId);

        model.addAttribute("afterArticle",afterArticle);
        model.addAttribute("preArticle",preArticle);

        // 获取随机文章
        List<Article> randomArticleList = articleService.listRandomArticle(articleId);

        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(articleId);

        //侧边栏
        //标签列表显示
        List<BlogTag> allTagList =tagService.listTag();

        model.addAttribute("randomArticleList",randomArticleList);
        model.addAttribute("mostArticleList",mostCommentArticleList);
        model.addAttribute("allTagList",allTagList);

        return "Home/Page/articleDetail";
    }

    /**
     * 点赞增加
     *
     * @param id 文章ID
     * @return 点赞量数量
     */
    @RequestMapping(value = "/article/like/{id}", method = {RequestMethod.POST})
    @ResponseBody
    public String increaseLikeCount(@PathVariable("id") Integer id) {
        Integer likeCount = articleService.increaseLikeCount(id);
        return JSON.toJSONString(likeCount);
    }

    /**
     * 文章访问量数增加
     *
     * @param id 文章ID
     * @return 访问量数量
     */
    @RequestMapping(value = "/article/view/{id}", method = {RequestMethod.POST})
    @ResponseBody
    public String increaseViewCount(@PathVariable("id") Integer id) {
        Integer articleCount= articleService.increaseViewCount(id);
        return JSON.toJSONString(articleCount);
    }

}
