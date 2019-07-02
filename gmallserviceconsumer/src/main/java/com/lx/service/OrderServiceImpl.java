package com.lx.service;

import com.lx.bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hekai  2019-06-30
 *
 * @desc
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    public List<UserAddress> initOrder(String userId) {

        System.out.println("id:" + userId);

        // 查询 用户收货地址
        List<UserAddress> userAddress = userService.getUserAddress(Integer.valueOf(userId));

        return userAddress;

    }
}
