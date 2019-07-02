package com.lx.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * create by hekai  2019-06-24
 *
 * @desc  自定义 异常处理器
 */
public class CustomerHandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        // 异常信息

        String msg = null;

        // 判断 异常类型

        if ( e instanceof MyException){

            //如果是  自定义异常  读取异常信息

            MyException myException = (MyException) e;

            msg = myException.getMessage();

            System.out.println(" msg :" + msg);

        }else  if (e instanceof ArithmeticException){

            msg = "数学 异常 不能为 0";

        } else{

            //如果是其他异常 读取 其他异常信息

            Writer out = new StringWriter();

            PrintWriter pw = new PrintWriter(out);

            e.printStackTrace(pw);
            msg = out.toString();
        }

        // 把错误 信息 发给相关人员

        // 返回错误界面
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg",msg);

        mv.setViewName("error");

        //返回视图
        return mv;
    }
}
