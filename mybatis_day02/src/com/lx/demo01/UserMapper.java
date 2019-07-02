package com.lx.demo01;

import com.lx.bean.QueryVo;
import com.lx.bean.User;

import java.util.List;

/**
 * create by hekai  2019-06-23
 *
 * @desc
 */
public interface UserMapper {

    /**
     * 通过 queryVo 查询
     * @param queryVo
     * @return
     */
    public User queryUserByVo(QueryVo queryVo);

    /**
     *  条件查询
     * @param u
     * @return
     */
    public List<User> queryUserByWhere(User u);


    /**
     * 通过 ids 查询 用户
     * @param ids
     * @return
     */
    public List<User> queryUserByIds(QueryVo queryVo);
}
