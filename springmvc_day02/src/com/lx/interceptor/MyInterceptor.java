package com.lx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by hekai  2019-06-25
 *
 * @desc
 */
public class MyInterceptor implements HandlerInterceptor {

    // Controller执行前调用此方法
    // 返回true表示继续执行，返回false中止
    // 这里可以加入登录校验、权限拦截等

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(" handler 之前调用这个方法 ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        // controller执行后但未返回视图前调用此方法
        System.out.println("handler 之后调用这个方法 ...");

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        //视图 执行后调用这个方法
        System.out.println("handler 之后后视图 返回后调用这个方法 ...");
    }
}
