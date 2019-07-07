package com.lx;

import redis.clients.jedis.Jedis;

/**
 * create by hekai  2019-07-04
 *
 * @desc
 */
public class Demo01 {

    public static void main(String[] args) {

        //获取对象
        Jedis jedis = new Jedis("192.168.43.123",6379);

        System.out.println(jedis.ping());

        //设置 数据
        jedis.set("name","深圳");

        System.out.println(jedis.get("name"));

    }
}
