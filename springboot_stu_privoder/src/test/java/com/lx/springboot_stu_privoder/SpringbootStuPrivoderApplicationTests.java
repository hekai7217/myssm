package com.lx.springboot_stu_privoder;

import com.lx.springboot_stu_privoder.service.StuServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootStuPrivoderApplicationTests {

    @Autowired
    private StuServiceImpl stuServiceImpl;

    @Test
    public void contextLoads() {
        stuServiceImpl.queryStus().forEach(e-> System.out.println(e.getName()));
    }

    @Test
    public void delStuServiceTmpl(){

        int i = stuServiceImpl.delStu(7);

        System.out.println("result:" + i);
    }

}
