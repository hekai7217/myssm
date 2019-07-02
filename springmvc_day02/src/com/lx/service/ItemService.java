package com.lx.service;

import com.lx.bean.Item;
import com.lx.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hekai  2019-06-24
 *
 * @desc
 */
@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    public List<Item> queryItemList(){

        //从数据库查询商品
        List<Item> items = this.itemMapper.queryItemList();

        return items;
    }

    /**
     * 通过id 查询 用户
     * @return
     */
    public Item queryItemById(int id){

        Item item = itemMapper.queryItemById(id);

        return item;

    }

    /**
     * 更新 item
     * @param item
     * @return
     */
    public int updateItem(Item item){

        return itemMapper.updateItem(item);

    }
}
