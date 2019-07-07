package com.hk.springboot_privoder_consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo  //使用 dubbo 的注解
@SpringBootApplication
public class SpringbootPrivoderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPrivoderConsumerApplication.class, args);
    }

}
