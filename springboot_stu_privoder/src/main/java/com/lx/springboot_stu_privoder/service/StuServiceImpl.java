package com.lx.springboot_stu_privoder.service;

import com.lx.bean.Student;
import com.lx.service.StuService;
import com.lx.springboot_stu_privoder.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hekai  2019-07-10
 *
 * @desc
 */
// 发布到 注册中心
//@com.alibaba.dubbo.config.annotation.Service(timeout = 3000,retries = 3)
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    // mq 发送数据
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public List<Student> queryStus() {
        return stuMapper.queryStus();
    }

    @Override
    public int insertStu(Student stu) {
        return stuMapper.insertStu(stu);
    }

    @Override
    public int delStu(int id) {

        int i = stuMapper.delStu(id);

        // 删除 成功  通知 redis 数据 需要同步
        if (i > 0 ){
            jmsTemplate.convertAndSend("test_queue","del");
        }
        return i;
    }

}
