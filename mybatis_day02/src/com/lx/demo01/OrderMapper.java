package com.lx.demo01;

import com.lx.bean.Order;
import com.lx.bean.User;

import java.util.List;

/**
 * create by hekai  2019-06-23
 *
 * @desc
 */
public interface OrderMapper {

    /**
     *  查询 所有的 order
     * @return
     */
    List<Order> queryOrderAll();

}
