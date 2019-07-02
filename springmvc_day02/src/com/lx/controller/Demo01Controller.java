package com.lx.controller;

import com.lx.bean.Item;
import com.lx.exception.MyException;
import com.lx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * create by hekai  2019-06-24
 *
 * @desc
 */
@Controller
public class Demo01Controller {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/list.do")
    public String testListItem(ModelMap map){

        List<Item> items = itemService.queryItemList();

        map.addAttribute("list",items) ;

        return "itemList";
    }

    @RequestMapping("/itemEdit.do")
    public String queryItemById(HttpServletRequest req, ModelMap modelMap){

        String id = req.getParameter("id");

        Item item = itemService.queryItemById(Integer.valueOf(id));

        modelMap.addAttribute("item",item);

        //直接返回字符串
        return "editItem";
    }

    @RequestMapping("/test01.do")
    public String testError(@RequestParam("id") int id) throws Exception {

        System.out.println("过来了...." + id);

        //自定义 异常
        if (id == 0) {
            throw new MyException("hello 我是自定义异常 ");
        } else {

            int a = 1 / 0;
        }
        return "success";
    }

//    @RequestMapping("/updateitem.do")
    public String testPic(HttpServletRequest req,Item item, MultipartFile pictureFile) throws IOException {

        //图片上传
        //设置 图片名称
        String picName = UUID.randomUUID().toString();

        //获取文件
        String oriName = pictureFile.getOriginalFilename();

        //获取 图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));

        //开始上次图片
        String realPath = req.getServletContext().getRealPath("/");

        System.out.println("realPath:" + realPath);

        pictureFile.transferTo(new File("/images" + picName  + extName) );

        // 更新商品
        item.setPic(picName + extName);

        itemService.updateItem(item);

        //
        return "forward:/itemEdit.do";
    }

}
