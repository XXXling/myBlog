package com.huining.ssm.blog.controller.home;

import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogLink;
import com.huining.ssm.blog.enums.LinkStatus;
import com.huining.ssm.blog.service.ArticleService;
import com.huining.ssm.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @description:公告
 * @author: huining
 * @time: 2020/5/5 20:57
 */
@Controller
public class LinkController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LinkService linkService;

    @RequestMapping("/applyLink")
    public String applyLinkView(Model model)  {
        //侧边栏显示
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount();
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);
        return "Home/Page/applyLink";
    }


    @RequestMapping(value = "/applyLinkSubmit",method = {RequestMethod.POST})
    @ResponseBody
    public void applyLinkSubmit(BlogLink link)  {
        link.setLinkStatus(LinkStatus.HIDDEN.getValue());
        link.setLinkCreateTime(new Date());
        link.setLinkUpdateTime(new Date());
        linkService.insertLink(link);
    }
}
