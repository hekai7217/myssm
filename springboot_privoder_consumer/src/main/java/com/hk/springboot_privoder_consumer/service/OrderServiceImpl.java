package com.hk.springboot_privoder_consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lx.bean.UserAddress;
import com.lx.service.OrderService;
import com.lx.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * create by hekai  2019-07-07
 *
 * @desc
 */
@Service
public class OrderServiceImpl implements OrderService {

    //从 注册中心 获取 service 的服务
    // reconnect 重试次数   2  不包含第一次
    // 连接次数
    // 超时 3秒  调用了  2 次
    @Reference(timeout = 3000,reconnect = "2",version = "1.0.0")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hello") //报错了 启动 我们自定的方法
    @Override
    public List<UserAddress> initOrder(String userId) {

        System.out.println("调用了服务 ..." + userId);

        List<UserAddress> userAddress = userService.getUserAddress(Integer.parseInt(userId));

        return userAddress;
    }

    public List<UserAddress> hello(String userId){

        return Arrays.asList(new UserAddress(1,"湖北武汉","123","12306"));

    }

}
