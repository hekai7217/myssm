package com.hk.springboot_privoder.service;

import com.lx.bean.UserAddress;
import com.lx.service.UserService;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import java.util.Arrays;
import java.util.List;

/**
 * create by hekai  2019-07-07
 *
 * @desc
 */
@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddress(int id) {

        UserAddress uaddr1 = new UserAddress(1,"深圳南山","1","123456");
        UserAddress uaddr2 = new UserAddress(1,"深圳翻身","2","123456");
        return Arrays.asList(uaddr1,uaddr2);

    }
}
