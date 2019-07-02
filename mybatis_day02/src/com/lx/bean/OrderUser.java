package com.lx.bean;

/**
 * create by hekai  2019-06-23
 *
 * @desc  关联查询
 *           orderUser extend order
 *              添加新的字段
 */
public class OrderUser extends Order{

    private String username;

    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "OrderUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}

