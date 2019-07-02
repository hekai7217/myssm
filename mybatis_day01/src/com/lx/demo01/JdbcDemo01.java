package com.lx.demo01;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * create by hekai  2019-06-21
 *
 * @desc jdbc 开发步骤
 */
public class JdbcDemo01 {

    @Test
    public void demo01() throws Exception{

        Connection conn = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //通过驱动 管理类 获取  conn 对象
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_test","root","root");

        //定义sql
        String sql = "select * from user where username = ?";

        // 获取 statement 对象
         ps = conn.prepareStatement(sql);

        //设置参数
        ps.setString(1,"王五");

        //执行 sql 操作
        rs = ps.executeQuery();

        //处理 rs
        while (rs.next()){

            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("username"));
        }


    }
}
