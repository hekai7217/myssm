package com.lx.service;

import com.lx.bean.UserAddress;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     *  通过 id 获取用户返回的  收货地址
     * @return
     */
    public List<UserAddress> getUserAddress(int id);

}
