package com.lx.demo02;

import com.lx.bean.Order;
import com.lx.bean.OrderUser;
import com.lx.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.util.List;

/**
 * create by hekai  2019-06-23
 *
 * @desc
 */
public class Demo01 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception{

        FileReader fr = new FileReader("src/SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(fr);

    }

    /**
     * 订单 和 用户 是
     *    一对一的关系
     *   orderUser  中   orderUser extends order {
     *
     *                   }
     */
    @Test
    public void demo01(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<OrderUser> orderUsers = mapper.queryOrderUser();

        orderUsers.forEach(e-> System.out.println(e));
    }

    /**
     *   订单和用户 一对一关系
     *       order 中 有user属性
     */
    @Test
    public void demo02(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Order> orders = mapper.queryUserResuMap();

        orders.forEach(e-> System.out.println(e));

    }

    /**
     *  一对多 查询
     *
     */
    @Test
    public void demo03(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.queryUserOrder();

        users.forEach(e-> System.out.println(e));
    }
}
