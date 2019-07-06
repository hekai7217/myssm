package com.lx.controller;

import com.lx.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * create by hekai  2019-07-05
 *
 * @desc
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

        System.out.println(username + " -- >" + password);

        //获取subject 对象
        Subject subject = SecurityUtils.getSubject();

        //判断是否  认证了
        if (!subject.isAuthenticated()) {

            // 把用户名 和密码 封装成 UserNamePassWordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            //记住我
            token.setRememberMe(true);

            try {
                //执行登录
                subject.login(token);

            } catch (AuthenticationException ae) {

                System.out.println("登录失败 " + ae.getMessage());
            }
        }

        System.out.println("执行 操作----> list ");

        return "list";
    }

    @RequestMapping("/hello")
    public void getMsg(HttpServletResponse rep) throws Exception{

        rep.getWriter().write("hello resp");

    }

    @RequestMapping("/logout")
    public String logout(){

        Subject currentUser = SecurityUtils.getSubject();

        currentUser.logout();

        return "unLogin";

    }

    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/test01")
    public String testShiroAnno(HttpSession session){

        shiroService.testMethod();

        session.setAttribute("key","hello word");


        return "list";
    }

}
