package com.lx.controller;

import com.lx.bean.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * create by hekai  2019-06-25
 *
 * @desc
 */
@Controller
public class Demo03Controller {

    @RequestMapping("/item/ids.do")
    public String demo01(QueryVo queryVo){

        System.out.println(Arrays.toString(queryVo.getIds()));
        System.out.println(queryVo.getIds().length);

        return "success";
    }
}
