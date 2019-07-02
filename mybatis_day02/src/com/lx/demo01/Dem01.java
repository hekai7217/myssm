package com.lx.demo01;

import com.lx.bean.Order;
import com.lx.bean.QueryVo;
import com.lx.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * create by hekai  2019-06-23
 *
 * @desc
 */
public class Dem01 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception{

        FileReader fr = new FileReader("src/SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(fr);

    }

    /**
     * 通过 queryVo 查询 user
     */
    @Test
    public void demo01() throws Exception{


        FileReader fr = new FileReader("src/SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(fr);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        QueryVo queryVo = new QueryVo();

        User user = new User();

        user.setId(2);
        queryVo.setUser(user);
        System.out.println(mapper.queryUserByVo(queryVo));

    }

    /**
     *  测试  resultMap 的配置
     */
    @Test
    public void demo02(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders = mapper.queryOrderAll();

        orders.forEach(e-> System.out.println(e));
    }

    @Test
    public void demo03(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = new User();

//        u.setSex('1');

        u.setUsername("%张%");

        List<User> users = mapper.queryUserByWhere(u);

        users.forEach(e-> System.out.println(e));

    }

    /**
     * 通过 id查询 User
     */
    @Test
    public void demo04(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(10);

        QueryVo queryVo = new QueryVo();
        queryVo.setIds(list);

        List<User> users = mapper.queryUserByIds(queryVo);

        users.forEach(e-> System.out.println(e));
    }


}
