package com.lx.demo02;

import com.lx.bean.Order;
import com.lx.bean.OrderUser;
import com.lx.bean.User;

import java.util.List;

/**
 * 测试 关联查询
 */
public interface UserMapper {


    /**
     *  关联查询
     *
     *   orderUser extends Order
     */
    public List<OrderUser> queryOrderUser();

    /**
     *
     *  关联查询
     *    order 中 包含属性 user
     *
     */
    public List<Order> queryUserResuMap();

    /**
     *  一对多查询
     *     一个 用户有多个订单
     * @return
     */
    public List<User> queryUserOrder();
}
