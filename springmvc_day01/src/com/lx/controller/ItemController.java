package com.lx.controller;

import com.lx.bean.Item;
import com.lx.bean.QueryVo;
import com.lx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by hekai  2019-06-23
 *
 * @desc
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    // 从本地 获取数据

//    @RequestMapping("/itemList")
    public ModelAndView queryItemList1(){

        System.out.println("过来了....");

        // 创建页面需要显示的商品数据
        List<Item> list = new ArrayList<>();

        list.add(new Item(1, "1华为 荣耀8", 2399, new Date(), "质量好！1"));
        list.add(new Item(2, "2华为 荣耀8", 2399, new Date(), "质量好！2"));
        list.add(new Item(3, "3华为 荣耀8", 2399, new Date(), "质量好！3"));
        list.add(new Item(4, "4华为 荣耀8", 2399, new Date(), "质量好！4"));
        list.add(new Item(5, "5华为 荣耀8", 2399, new Date(), "质量好！5"));

        //创建 ModelAndView

        ModelAndView mv = new ModelAndView();

        //设置数据模型
        mv.addObject("list",list);

        //设置jsp 视图 路径
        mv.setViewName("/WEB-INF/jsp/itemList.jsp");


        return mv;
    }

    @RequestMapping("/itemList.do")
    public ModelAndView queryListItem(){

        List<Item> items = itemService.queryItemList();

        ModelAndView mv = new ModelAndView();

        mv.addObject("list",items);
        //直接 设置  itemList 字符串  不用给前缀  和 后缀
        mv.setViewName("itemList");

        return mv;
    }

    @RequestMapping("/itemEdit.do")
    public String queryItemById(HttpServletRequest req, ModelMap modelMap){

        //1. 可以从 req 中 获取参数

        //2. 当请求的参数名称和处理器形参名称一致时会将请求参数与形参进行绑定

        //3. @RequestParam常用于处理简单类型的绑定。

        //4. 请求的参数名称和pojo的属性名称一致，会自动将请求参数赋值给pojo的属性。

        //从 req 中 获取数据
        String id = req.getParameter("id");

        Item item = itemService.queryItemById(Integer.valueOf(id));

        modelMap.addAttribute("item",item);

        //直接返回字符串
        return "editItem";
    }

    /**
     *
     *
     * @param item
     * @return
    @RequestMapping("/updateitem.do")
    public String updateItem(Item item){
        System.out.println(item);
        return "success";
    }

     */

    @RequestMapping("/updateitem.do")
    public String updateItem(Item item){
        System.out.println(item);
        return "success";
    }

    @RequestMapping("/item/selectItem.do")
    public String selectItem(QueryVo queryVo){

        Item item = queryVo.getItem();
        System.out.println(item.getId());
        System.out.println(item.getName());

        return "success";
    }
}
