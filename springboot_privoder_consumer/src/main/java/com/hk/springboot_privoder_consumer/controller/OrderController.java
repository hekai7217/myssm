package com.hk.springboot_privoder_consumer.controller;

import com.lx.bean.UserAddress;
import com.lx.service.OrderService;
import com.lx.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * create by hekai  2019-07-07
 *
 * @desc
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *  初始化订单操作
     * @param id
     * @return
     */

    @ResponseBody
    @RequestMapping("/order/{id}")
    public List<UserAddress> initOrder(@PathVariable("id") String id){

        List<UserAddress> list = orderService.initOrder(id);

        return list;

    }


    @ResponseBody
    @RequestMapping("/demo01")
    public Object test01(){

        HashMap<String,String> map = new HashMap<>();

        map.put("aa","11");

        return map;

    }
}
