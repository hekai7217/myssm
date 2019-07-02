package com.lx.test;

import com.lx.bean.User;
import com.lx.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;

/**
 * create by hekai  2019-06-21
 *
 * @desc
 */
public class Demo02 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception {

        FileReader fr = new FileReader(new File("src/SqlMapConfig.xml"));
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(fr);
    }

    @Test
    public void demo01(){

        //查询操作
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);

        System.out.println(user);
    }

    @Test
    public void demo02(){

        // 更新操作
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setId(25);
        user.setUsername("段正淳");
        mapper.updateUser(user);

        sqlSession.commit();

    }

    @Test
    public void demo03(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u = new User();

        u.setUsername("张无忌");
        u.setAddress("光明顶");

        mapper.saveUser(u);

        //事务提交
        sqlSession.commit();

    }
}
