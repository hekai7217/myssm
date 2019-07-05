package com.lx.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by hekai  2019-07-05
 *
 * @desc
 */

@Controller
public class LoginController {

    @RequestMapping("/shiro_web/login")
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

        return "redirect:/list.jsp";
    }

}
