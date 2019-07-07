package com.hk.springboot_privoder.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lx.bean.UserAddress;
import com.lx.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * create by hekai  2019-07-07
 *
 * @desc
 */
@Service(version = "2.0.0")
@Component
public class UserServiceImpl02 implements UserService {
    @Override
    public List<UserAddress> getUserAddress(int id) {

        System.out.println("调用了服务 ");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        UserAddress uaddr1 = new UserAddress(2,"深圳南山","1","123456");
        UserAddress uaddr2 = new UserAddress(2,"深圳翻身","2","123456");
        return Arrays.asList(uaddr1,uaddr2);

    }
}
