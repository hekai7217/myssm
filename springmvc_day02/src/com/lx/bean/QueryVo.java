package com.lx.bean;

/**
 * create by hekai  2019-06-24
 *
 * @desc  使用包装对象商品信息 查询 条件
 */
public class QueryVo {

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private Integer [] ids;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

}
