package com.lx.service;

import com.lx.bean.UserAddress;

import java.util.Arrays;
import java.util.List;

/**
 * create by hekai  2019-06-30
 *
 * @desc
 *  1. 将服务 提供者 注册到 注册中心 (暴露服务)
 *        1)  导入dubbo 依赖   操作zookeeper 的客户端  curator
 *        2） 配置服务提供者
 *
 *  2. 让服务消费者 去 注册中心订阅 服务提供者的服务地址
 *
 */
public class UserServiceImpl implements UserService{

    public List<UserAddress> getUserAddress(int id) {
        UserAddress uaddr1 = new UserAddress(1,"深圳南山","1","123456");
        UserAddress uaddr2 = new UserAddress(1,"深圳宝安","1","123456");
        return Arrays.asList(uaddr1,uaddr2);
    }
}
