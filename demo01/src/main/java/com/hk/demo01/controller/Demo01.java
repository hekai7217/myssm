package com.hk.demo01.controller;

import org.springframework.web.bind.annotation.*;

/**
 * create by hekai  2019-06-27
 *
 * @desc
 */
@RestController
public class Demo01 {
    @RequestMapping("/demo")
    public String getMsg(@RequestParam("name")String name){

        return "hello " + name;
    }

    @RequestMapping(value = "/demo/{ids}",method = RequestMethod.PUT)
    public String update(@PathVariable("ids") int ids){

        System.out.println("更新 操作 ...");
        return "hello" + ids;

    }
}
