package com.lx.realms;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * create by hekai  2019-07-05
 *
 * @desc
 */
public class Test01 {

    // 加密 测试
    public static void main(String[] args) {

        //加密算法
        String alName = "MD5";
        String password = "123456";

        //盐值

        //  admin   0ea9114a57ee221805a9cd4f1ce40663
        //  user    bac947aef187c26e7878bcc651dcd2e3

        ByteSource salt = ByteSource.Util.bytes("user");

        //加密次数
        int hashIteration = 100;

        /**
         *  加密算法
         *  密码
         *  加盐
         *  加密次数
         */
        Object result = new SimpleHash(alName,password,salt,hashIteration);

        System.out.println( "result :" + result);
    }
}
