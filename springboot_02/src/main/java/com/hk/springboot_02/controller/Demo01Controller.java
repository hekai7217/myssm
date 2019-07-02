package com.hk.springboot_02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by hekai  2019-07-01
 *
 * @desc
 */
@RestController
public class Demo01Controller {

    @Value("${test.env}")
    private String env;

    @RequestMapping("/test")
    public String getEnv(){

        return "当前环境:" + env;

    }

    @RequestMapping("/test01")
    public String getTest(){

        return "当前环境 - > test ";

    }

}
