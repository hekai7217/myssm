package com.hk.springboot_01.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * create by hekai  2019-07-01
 *
 * @desc
 */
@RestController
public class Demo01Controller {

    private final Map<String, Object> params = new HashMap<String, Object>();

    @RequestMapping("/demo01")
    public String demo01(){

        return "hello springboot";
    }

    @PutMapping("/put")
    public Object put(String id){

        params.clear();
        params.put("id",id);
        return params;

    }

    @DeleteMapping("/del/{id}")
    public Object del(@PathVariable("id") String id){
        params.clear();
        params.put("id",id);

        return params;
    }
}
