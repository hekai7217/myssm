package com.lx;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * create by hekai  2019-07-04
 *
 * @desc
 */
public class Demo02 {

    public static void main(String[] args) {

        Jedis jedis = JedisPoolUtil.getJedis();
        // map 的  操作

        Map<String,String> map = new HashMap<>();

        map.put("age","30");
        map.put("name","mayun");

        jedis.hmset("map",map);

        System.out.println(jedis.hget("map","age"));
        System.out.println(jedis.hget("map","name"));

    }

}
