package com.huining.ssm.blog.controller.admin;

import com.huining.ssm.blog.entity.Article;
import com.huining.ssm.blog.entity.BlogComment;
import com.huining.ssm.blog.entity.User;
import com.huining.ssm.blog.service.ArticleService;
import com.huining.ssm.blog.service.CommentService;
import com.huining.ssm.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.huining.ssm.blog.util.MyUtils.getIpAddr;

/**
 * @Author: huining
 * @Date: 2020/4/24 15:43
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/admin")
    public String index(Model model)  {
        // 文章列表
        List<Article> articles = articleService.listArticle(5);
        model.addAttribute(articles);
        // 评论列表
        List<BlogComment> blogComments = commentService.listComments(5);
        model.addAttribute(blogComments);
        return "Admin/index";
    }

    /**
     * 登录页面显示
     *
     * @return
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "Admin/login";
    }

    /**
     * 登录验证
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response)  {
        Map<String, Object> map = new HashMap<String, Object>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");

        User param = new User(username,"");
        User user = userService.queryUser(param);
        if (user == null || !user.getUserPass().equals(password)){
            map.put("code",0);
            map.put("msg","用户名或密码错误");
        }else {
            map.put("code",1);
            map.put("msg","");
            request.getSession().setAttribute("user",user);
            if (rememberme != null){
                Cookie nameCookie = new Cookie("username",user.getUserName());
                Cookie passCookie = new Cookie("password",user.getUserPass());
                nameCookie.setMaxAge(3 * 24 * 60 * 60);
                passCookie.setMaxAge(3 * 24 * 60 * 60);

                response.addCookie(nameCookie);
                response.addCookie(passCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            userService.updateUsere(user);
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/admin/logout")
    public String logout(HttpSession session)  {
        session.removeAttribute("username");
        session.invalidate();
        return "redirect:/login";
    }
}
