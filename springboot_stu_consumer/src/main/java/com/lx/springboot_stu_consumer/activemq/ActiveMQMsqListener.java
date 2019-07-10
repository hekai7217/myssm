package com.lx.springboot_stu_consumer.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * create by hekai  2019-07-10
 *
 * @desc  mq 的监听
 */
@Service
public class ActiveMQMsqListener {

    //re
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @JmsListener(destination = "test_queue")
    public void reviceMsg(String msg){

        System.out.println("收到 mq====> " + msg);

        if (msg != null && msg.equals("del")){
            redisTemplate.opsForValue().set("stus",null);
        }
    }
}
