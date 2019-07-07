package com.lx.bean;

/**
 * create by hekai  2019-07-08
 *
 * @desc
 */
public class UserAddress {

    private int id;

    private String address;

    private String userid;

    private String phoneNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public UserAddress(int id, String address, String userid, String phoneNum) {
        this.id = id;
        this.address = address;
        this.userid = userid;
        this.phoneNum = phoneNum;
    }

    public UserAddress() {
    }
}
