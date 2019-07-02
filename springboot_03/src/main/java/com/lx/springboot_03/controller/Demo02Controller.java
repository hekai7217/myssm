package com.lx.springboot_03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by hekai  2019-07-02
 *
 * @desc
 */
@Controller
public class Demo02Controller {

    @RequestMapping("/demo01")
    public String demo01(ModelMap map){

        map.put("msg","hello world");

        return "index03";
    }
}
