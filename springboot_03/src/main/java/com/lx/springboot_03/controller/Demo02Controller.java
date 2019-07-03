package com.lx.springboot_03.controller;

import com.lx.springboot_03.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

        map.put("key",new Date());

        User u = new User();

        u.setUsername("张三");
        u.setPassword("1234");

        map.put("user",u);

        return "index03";
    }

    @RequestMapping("/demo02")
    public String demo02(ModelMap map){

        map.put("sex",'男');
        map.put("id",2);

        List<User> list = new ArrayList<>();
        list.add(new User("张三","20"));
        list.add(new User("李四","22"));
        list.add(new User("王五","24"));
        map.addAttribute("list", list);


        Map<String,User> hashmap = new HashMap<>();

        hashmap.put("u1",new User("马云","1234"));
        hashmap.put("u2",new User("马化腾","aaaa"));
        hashmap.put("u3",new User("雷军","cccc"));

        map.addAttribute("map", hashmap);

        return "index04";
    }

    @RequestMapping("/show1")
    public String showInfo(ModelMap model, HttpServletRequest req){

        req.setAttribute("req","httprequest");
        req.getSession().setAttribute("sess","session");
        req.getSession().getServletContext().setAttribute("app","application");

        return "index05";
    }

    @RequestMapping("/show03")
    public String show03(@RequestParam("id")String id,@RequestParam("name")String name){

        System.out.println("show03*****");
        System.out.println("id :" + id);
        System.out.println("name :" + name);

        return "index05";
    }

    @RequestMapping("/show04/{id}")
    public String show04(@PathVariable("id")String id,@RequestParam("name")String name){

        System.out.println("show04*****");
        System.out.println("id :" + id);
        System.out.println("name :" + name);
        return "index05";
    }

}
