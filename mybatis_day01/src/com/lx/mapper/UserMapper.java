package com.lx.mapper;

import com.lx.bean.User;

/**
 * create by hekai  2019-06-21
 *
 * @desc
 */
public interface UserMapper {

    public void saveUser(User u);

    public User queryUserById(int id);

    public void updateUser(User u);
}
