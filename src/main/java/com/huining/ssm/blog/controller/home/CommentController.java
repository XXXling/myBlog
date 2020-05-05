package com.huining.ssm.blog.controller.home;

import cn.hutool.http.HtmlUtil;
import com.huining.ssm.blog.dto.JsonResult;
import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogComment;
import com.huining.ssm.blog.enums.ArticleStatus;
import com.huining.ssm.blog.enums.BlogRole;
import com.huining.ssm.blog.service.ArticleService;
import com.huining.ssm.blog.service.CommentService;
import com.huining.ssm.blog.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public JsonResult insertComment(HttpServletRequest request, BlogComment comment){
        //添加评论
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(MyUtils.getIpAddr(request));
        if (request.getSession().getAttribute("user") != null) {
            comment.setCommentRole(BlogRole.ADMIN.getValue());
        } else {
            comment.setCommentRole(BlogRole.VISITOR.getValue());
        }
        comment.setCommentAuthorAvatar(MyUtils.getGravatar(comment.getCommentAuthorEmail()));

        //过滤字符，防止XSS攻击
        comment.setCommentContent(HtmlUtil.escape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtil.escape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtil.escape(comment.getCommentAuthorEmail()));
        comment.setCommentAuthorUrl(HtmlUtil.escape(comment.getCommentAuthorUrl()));

        try {
            commentService.insertComment(comment);
            Article article = articleService.getArticleDetails(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
            articleService.updateCommentCount(article.getArticleId());
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult().fail();
        }


        return new JsonResult().ok();
    }
}
