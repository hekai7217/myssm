package com.lx.springboot_stu_consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SpringbootStuConsumerApplicationTestRedis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void contextLoads() {


        redisTemplate.opsForValue().set("k1","v1");

        System.out.println(redisTemplate.opsForValue().get("k1"));


    }

}
