package com.lx.service;

import com.lx.bean.UserAddress;

import java.util.List;

public interface OrderService {

    public List<UserAddress> initOrder(String userId);

}
