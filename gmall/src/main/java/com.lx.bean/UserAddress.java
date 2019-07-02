package com.lx.bean;

import java.io.Serializable;

/**
 * create by hekai  2019-06-30
 *
 * @desc
 */
public class UserAddress implements Serializable {

    private int id;

    private String userAddress;

    private String userId;

    private String phoneNum;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public UserAddress() {
    }

    public UserAddress(int id, String userAddress, String userId, String phoneNum) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.phoneNum = phoneNum;
    }
}
