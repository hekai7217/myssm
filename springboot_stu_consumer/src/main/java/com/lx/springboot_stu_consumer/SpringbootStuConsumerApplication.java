package com.lx.springboot_stu_consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpringbootStuConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStuConsumerApplication.class, args);
    }

}
