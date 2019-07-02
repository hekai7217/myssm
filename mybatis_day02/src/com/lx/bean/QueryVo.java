package com.lx.bean;

import java.util.List;

/**
 * create by hekai  2019-06-23
 *
 * @desc
 */
public class QueryVo {

    // 包含其他的pojo
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     *  查询 参数是 list
     */
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

