package com.lx;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * create by hekai  2019-07-04
 *
 * @desc  redis 的 连接池操作
 */
public class JedisPoolUtil {

    private static JedisPool pool = null;

    static {
        Properties pro = new Properties();
        // 加载配置文件
        try {
            pro.load(new FileInputStream(new File("redis.properties")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));// 最大闲置个数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));// 最小闲置个数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));// 最大连接数
        pool = new JedisPool(poolConfig, pro.getProperty("redis.url"),
                Integer.parseInt(pro.get("redis.port").toString()));

    }


    /**
     *  获取 连接池
     * @return
     */
    public static Jedis getJedis(){

        // Jedis.close()  关闭资源

        return pool.getResource();
    }

    @Test
    public void demo01(){
        System.out.println(JedisPoolUtil.getJedis());
    }
}
