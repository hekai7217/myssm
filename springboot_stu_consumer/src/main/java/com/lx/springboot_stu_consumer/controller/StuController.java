package com.lx.springboot_stu_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lx.bean.Student;
import com.lx.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by hekai  2019-07-10
 *
 * @desc
 */
@RestController
public class StuController {

    @Reference(check = false)
    private StuService stuService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/stus")
    public List<Student> queryStus() {

        List<Student> stus = null;

        // 从redis中获取数据
        String stus_json = redisTemplate.opsForValue().get("stus");
        if (stus_json != null){
            System.out.println(" 从缓存 redis =====中获取数据 ");
             stus = JSON.parseArray(stus_json, Student.class);
        }
        if (stus == null) {
            //从数据库总获取数据
            System.out.println("从数据库获取数据 ....");
            stus = stuService.queryStus();
            //把 stus 转成 json 存到 redis中
            redisTemplate.opsForValue().set("stus",JSON.toJSONString(stus));
        }
        return stus;
    }

    @RequestMapping("/stu")
    public int insertStu(Student stu) {

        int insert = stuService.insertStu(stu);

        return insert;
    }

    @RequestMapping("/studel/{id}")
    public int insertStu(@PathVariable("id") int id) {

        int del = stuService.delStu(id);

        if (del > 0){
            System.out.println("删除成功");
        }
        return del;
    }

}
