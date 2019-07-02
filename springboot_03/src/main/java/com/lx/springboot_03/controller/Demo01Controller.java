package com.lx.springboot_03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by hekai  2019-07-02
 *
 * @desc
 */
@Controller
public class Demo01Controller {

    @RequestMapping("/index01")
    public String index01(ModelMap map){

        map.put("msg","入门程序");
        return "index";

    }

    @RequestMapping("/index02")
    public String index02(ModelMap map){

        map.put("msg","springboot value测试");

        return "index02";

    }

    @RequestMapping("/save")
    public String index03(@RequestParam("name")String name){

        System.out.println( "name : " + name);

        return "index02";
    }

}
