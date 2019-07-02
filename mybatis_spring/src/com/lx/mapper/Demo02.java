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
 * @desc  注解测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo02 {

    @Autowired
    private UserDao userDao;

    /**
     *  测试 注解通过id 查询 user
     */
    @Test
    public void demo01(){

        User user = userDao.queryUserById(2);

        System.out.println(user);
    }

    /**
     *   测试 通过注解把 user 插入到数据库 中
     */
    @Test
    public void demo02(){

        User u = new User();

        u.setUsername("雷阿伦");
        u.setAddress("西雅图");

        userDao.saveUser(u);

//        userDao.saveUser(u.getUsername(),u.getAddress());
    }

    /**
     * 测试  更新操作
     */
    @Test
    public void demo03(){

        userDao.updateUser(29,"雷军");

    }

    /**
     * 测试 删除操作
     */
    @Test
    public void demo04(){
        userDao.deleteUser(30);
    }
}
