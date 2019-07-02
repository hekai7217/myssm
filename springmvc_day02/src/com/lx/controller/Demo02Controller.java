package com.lx.controller;

import com.lx.bean.Item;
import com.lx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * create by hekai  2019-06-25
 *
 * @desc
 */
@Controller
public class Demo02Controller {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/testJson.do")
    @ResponseBody
    public Item testJson(@RequestBody Item item){

        System.out.println("过来了 ....");

        System.out.println(item);

        return item;

    }

    @RequestMapping("/test02.do")
    @ResponseBody
    public Item testJson01(@RequestParam("id") int id){

        Item item = new Item();

        item.setId(id);
        item.setName("张三" + id);

        System.out.println(item);

        return item;
    }

    @RequestMapping("/item/{id}/.do")
    @ResponseBody
    public Item queryItemById(@PathVariable int id){
        return this.itemService.queryItemById(id);
    }

    @RequestMapping(value = "/updateitem.do",method = RequestMethod.POST)
    public String updateItem(Item item){

        System.out.println(item);
        itemService.updateItem(item);

        return "success";
    }
}

