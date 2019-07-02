package com.lx.service;

import com.lx.bean.UserAddress;

import java.util.List;

/**
 * create by hekai  2019-06-30
 *
 * @desc
 */
public interface OrderService {

    /**
     * 初始化订单
     * @param userId
     * @return
     */
    public List<UserAddress> initOrder(String userId);

}
