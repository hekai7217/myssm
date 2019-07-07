package com.hk.springboot_privoder;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo //启动 dubbo 注解
@SpringBootApplication
public class SpringbootPrivoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPrivoderApplication.class, args);
    }

}
