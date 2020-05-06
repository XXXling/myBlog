package com.huining.ssm.blog.controller.admin;

import com.huining.ssm.blog.entity.BlogUser;
import com.huining.ssm.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: huining
 * @time: 2020/5/6 17:06
 */
@Controller
@RequestMapping("/admin/user")
public class BackUserController {

    @Autowired
    private UserService userService;

    /**
     * 后台用户列表显示
     *
     * @return
     */
    @RequestMapping(value = "")
    public ModelAndView userList()  {
        ModelAndView modelandview = new ModelAndView();
        List<BlogUser> userList = userService.listUser();
        modelandview.addObject("userList",userList);

        modelandview.setViewName("Admin/User/index");
        return modelandview;

    }

    /**
     * 后台添加用户页面显示
     *
     * @return
     */
    @RequestMapping(value = "/insert")
    public ModelAndView insertUserView()  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/User/insert");
        return modelAndView;
    }

    /**
     * 检查用户名是否存在
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
    @ResponseBody
    public String checkUserName(HttpServletRequest request)  {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = request.getParameter("username");
        BlogUser user = userService.queryUser(new BlogUser(username,null));
        int id = Integer.valueOf(request.getParameter("id"));
        //用户名已存在,但不是当前用户(编辑用户的时候，不提示)
        if(user!=null) {
            if(user.getUserId()!=id) {
                map.put("code", 1);
                map.put("msg", "用户名已存在！");
            }
        } else {
            map.put("code",0);
            map.put("msg","");
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    /**
     * 检查Email是否存在
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkUserEmail",method = RequestMethod.POST)
    @ResponseBody
    public String checkUserEmail(HttpServletRequest request)  {
        Map<String, Object> map = new HashMap<String, Object>();
        String email = request.getParameter("email");
        BlogUser user = userService.queryUser(new BlogUser(null,email));
        int id = Integer.valueOf(request.getParameter("id"));
        //用户名已存在,但不是当前用户(编辑用户的时候，不提示)
        if(user!=null) {
            if(user.getUserId()!=id) {
                map.put("code", 1);
                map.put("msg", "电子邮箱已存在！");
            }
        } else {
            map.put("code",0);
            map.put("msg","");
        }
        String result = new JSONObject(map).toString();
        return result;
    }


    /**
     * 后台添加用户页面提交
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertUserSubmit(BlogUser user)  {
        BlogUser user2 = userService.queryUser(new BlogUser(user.getUserName(),null));
        BlogUser user3 = userService.queryUser(new BlogUser(null,user.getUserEmail()));
        if(user2==null&&user3==null) {
            user.setUserRegisterTime(new Date());
            user.setUserStatus(1);
            userService.insertUser(user);
        }
        return "redirect:/admin/user";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id)  {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    /**
     * 编辑用户页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editUserView(@PathVariable("id") Integer id)  {
        ModelAndView modelAndView = new ModelAndView();

        BlogUser user =  userService.queryUser(new BlogUser(id));
        modelAndView.addObject("user",user);

        modelAndView.setViewName("Admin/User/edit");
        return modelAndView;
    }


    /**
     * 编辑用户提交
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    public String editUserSubmit(BlogUser user)  {
        userService.updateUser(user);
        return "redirect:/admin/user";
    }

    /**
     * 基本信息页面显示
     *
     * @return
     */
    @RequestMapping(value = "/profile")
    public ModelAndView userProfileView(HttpSession session)  {

        ModelAndView modelAndView = new ModelAndView();
        BlogUser sessionUser = (BlogUser) session.getAttribute("user");
        BlogUser user =  userService.queryUser(new BlogUser(sessionUser.getUserId()));
        modelAndView.addObject("user",user);

        modelAndView.setViewName("Admin/User/profile");
        return modelAndView;
    }
}