package org.project.springmvc.usermag.controller;

import org.project.springmvc.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * RequestMapping通过DefaultAnnotationHandlerMappering完成"路径"与处理"该路径方法"之间的映射关系
 */
@RequestMapping("/usermag")
@Controller
public class LoginController {
    /**
     * 登录方法
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String userName=request.getParameter("name");
        String userPwd=request.getParameter("pwd");
        UserBean user=new UserBean();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        System.out.println(user);
        return null;
    }
    @RequestMapping("/login1")
    public ModelAndView login(String name,String pwd){
        UserBean user=new UserBean();
        user.setUserName(name);
        user.setUserPwd(pwd);
        System.out.println(user);
        return null;
    }

    /**
     * value = {"/login2"}  完成路径映射，表示/login3这种路径发出请求，由以下方法执行
     * value={"/login3","/login4"},表示/login3、/login这两个路径发出请求，由以下方法执行
     * value={"/login*"},表示可以匹配/login123、/login、/loginasdsa
     * value={"/login/*},表示可以匹配/login/asd
     * value={"/login?"},表示可以匹配/logins、/login2
     * value={"/login**"},表示可以匹配/login/asd/asddx.
     * @param user
     * @return
     */
    @RequestMapping(value = {"/login2"},method = {RequestMethod.POST})
    public ModelAndView login(UserBean user){
        System.out.println(user);
        return null;
    }
}
