package com.lx.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * create by hekai  2019-07-08
 *
 * @desc spring-activemp 消费者
 */
public class SpringConsumer {

    public static void main(String[] args) throws Exception {

        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //等待
        System.in.read();
    }

}

