package com.lx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by hekai  2019-06-28
 *
 * @desc
 */

@RestController
public class DemoController {


    /**
     * delete 删除
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") int id, ModelMap map) {

        map.addAttribute("msg", "delete 请求 " + id);

        return "delete 请求 " + id;
    }

    /**
     * delete 删除
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.PUT)
    public String testPut(@PathVariable("id") int id, ModelMap map) {

        map.addAttribute("msg", "put 请求 " + id);

        return "put 请求 " + id;
    }

    /**
     * delete 删除
     *
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.POST)
    public String testPost(@PathVariable("id") int id, ModelMap map) {

        map.addAttribute("msg", "Post 请求 " + id);
        return "success";
    }

    /**
     * delete 删除
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.GET)
    public String testGet(@PathVariable("id") int id, ModelMap map) {

        map.addAttribute("msg", "get 请求 " + id);

        return "success";
    }
}
