package com.hk.springboot_privoder_consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lx.bean.UserAddress;
import com.lx.service.OrderService;
import com.lx.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hekai  2019-07-07
 *
 * @desc
 */
@Service
public class OrderServiceImpl implements OrderService {

    //从 注册中心 获取 service 的服务
    @Reference
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {

        System.out.println("调用了服务 ..." + userId);

        List<UserAddress> userAddress = userService.getUserAddress(Integer.parseInt(userId));

        return userAddress;
    }
}
