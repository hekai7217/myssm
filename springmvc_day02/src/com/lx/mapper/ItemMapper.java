package com.lx.mapper;

import com.lx.bean.Item;

import java.util.List;

/**
 * create by hekai  2019-06-24
 *
 * @desc
 */
public interface ItemMapper {

    /**
     * 查询 所有的商品
     * @return
     */
    public List<Item> queryItemList();

    /**
     *  通过id 查询 id
     * @param id
     * @return
     */
    public Item queryItemById(int id);

    /**
     * 更新 item 数据库操作
     * @param item
     * @return
     */
    public int updateItem(Item item);

}
