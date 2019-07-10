package com.lx.springboot_stu_privoder;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//@EnableHystrix  //开启  hystrix 注解
@EnableDubbo    //开启  dubbo   注解
@SpringBootApplication
public class SpringbootStuPrivoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStuPrivoderApplication.class, args);
    }

}
