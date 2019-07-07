package com.hk.springboot_privoder.service;

import com.lx.bean.UserAddress;
import com.lx.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import java.util.Arrays;
import java.util.List;

/**
 * create by hekai  2019-07-07
 *
 * @desc
 */
@Service(version = "1.0.0")
@Component
public class UserServiceImpl01 implements UserService {

    // 异常了  启用 Hystrix
    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddress(int id) {

        System.out.println("调用了服务 20882");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        UserAddress uaddr1 = new UserAddress(1,"深圳南山","1","123456");
        UserAddress uaddr2 = new UserAddress(1,"深圳翻身","2","123456");

        //服务降级 测试
        if (Math.random() < 0.5){

            throw new RuntimeException();
        }

        return Arrays.asList(uaddr1,uaddr2);

    }
}
