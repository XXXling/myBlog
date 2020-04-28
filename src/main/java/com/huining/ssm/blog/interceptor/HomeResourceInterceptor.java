package com.huining.ssm.blog.interceptor;

import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogCategory;
import com.huining.ssm.blog.entity.BlogMenu;
import com.huining.ssm.blog.entity.BlogOptions;
import com.huining.ssm.blog.enums.ArticleStatus;
import com.huining.ssm.blog.enums.LinkStatus;
import com.huining.ssm.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huining
 * @Date: 2020/4/20 14:13
 */
@Component
public class HomeResourceInterceptor  implements HandlerInterceptor {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private OptionsService optionsService;
    /**
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 菜单显示
        List<BlogMenu> menuList = menuService.listMenu();
        request.setAttribute("menuList",menuList);

        // 类别
        List<BlogCategory> categoryList = categoryService.listCategory();
        request.setAttribute("categoryList",categoryList);

        // 获得网站概况
        List<String> siteBasicStatistics = new ArrayList<String>();
        siteBasicStatistics.add(articleService.countArticle(ArticleStatus.PUBLISH.getValue())+"");
        siteBasicStatistics.add(articleService.countArticleComment() + "");
        siteBasicStatistics.add(categoryService.countCategory() + "");
        siteBasicStatistics.add(tagService.countTag() + "");
        siteBasicStatistics.add(linkService.countLink(LinkStatus.NORMAL.getValue()) + "");
        siteBasicStatistics.add(articleService.countArticleView() + "");
        request.setAttribute("siteBasicStatistics", siteBasicStatistics);

        //最后更新的文章
        Article lastUpdateArticle = articleService.getLastUpdateArticle();
        request.setAttribute("lastUpdateArticle",lastUpdateArticle);

        //页脚显示
        //博客基本信息显示(Options)
        BlogOptions options = optionsService.getOptions();
        request.setAttribute("options",options);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
