package com.lx.test;

import com.lx.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * create by hekai  2019-06-21
 *
 * @desc
 */
public class Demo01 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception {

        FileReader fr = new FileReader(new File("src/SqlMapConfig.xml"));
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(fr);

    }

    @Test
    public void demo01() throws Exception {

        FileReader fr = new FileReader(new File("src/SqlMapConfig.xml"));

        // 创建 sqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        sqlSessionFactory = sqlSessionFactoryBuilder.build(fr);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        Object user = sqlSession.selectOne("test.queryUserById", 1);

        System.out.println(user);

    }

    @Test
    public void demo02() {

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        List<Object> list = sqlSession.selectList("test.queryUserByUsername", "%王%");

        list.forEach(e -> System.out.println(e));


    }

    @Test
    public void demo03() {

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        List<Object> list = sqlSession.selectList("test.queryUserByUsername1", "%王%");

        list.forEach(e -> System.out.println(e));

    }

    /**
     * 保存用户
     */
    @Test
    public void demo04() {

        SqlSession sqlSession = this.sqlSessionFactory.openSession();


        User user = new User();
        user.setUsername("张飞");
        user.setSex('1');
        user.setAddress("蜀国");

        sqlSession.insert("saveUser",user);

        //需要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    /**
     * 更新操作
     */
    @Test
    public void demo05() {

        SqlSession sqlSession = this.sqlSessionFactory.openSession();


        User user = new User();

        user.setId(25);
        user.setUsername("关羽");
        user.setSex('1');
        user.setAddress("蜀国");

        sqlSession.insert("updateUserById",user);

        //需要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    public void demo06(){

        //创建 sqlsession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int deleteUserById = sqlSession.delete("deleteUserById", 48);

        System.out.println(deleteUserById);

        //提交事务
        sqlSession.commit();
    }
}