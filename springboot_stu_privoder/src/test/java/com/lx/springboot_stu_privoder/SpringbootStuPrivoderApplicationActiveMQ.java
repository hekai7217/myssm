package com.lx.springboot_stu_privoder;

import com.lx.springboot_stu_privoder.service.StuServiceImpl;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootStuPrivoderApplicationActiveMQ {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void sendMessage() {

        Destination destination = new ActiveMQQueue("test_queue");

        this.jmsTemplate.convertAndSend(destination,"hello world");

        System.out.println("发送完毕...");
    }

}
