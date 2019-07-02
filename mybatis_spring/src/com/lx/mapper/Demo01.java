package com.lx.mapper;

import com.lx.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * create by hekai  2019-06-23
 *
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo01 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void demo01() {


        User user = userMapper.queryUserById(1);

        System.out.println(user);

    }

    @Test
    public void demo02() {

        User u = new User();

        u.setUsername("张三丰");
        u.setSex('1');

        u.setAddress("武当山");
        userMapper.saveUser(u);
    }

    @Test
    public void demo03(){

        User u = new User();

        u.setId(25);

        u.setUsername("周芷若");

        userMapper.updateUser(u);

    }
}
