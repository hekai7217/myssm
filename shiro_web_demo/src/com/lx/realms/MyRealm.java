package com.lx.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
/**
 * create by hekai  2019-07-05
 *
 * @desc   自定义real 操作
 */
public class MyRealm extends AuthorizingRealm {

    /**
     *  认证操作
     * @param  token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("过来了 ---->" + token);


        //1 把 AuthenticationToken 转成 usernamePasswordtoken

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2 从 UsernamePasswordToken 获取 username
        String username = upToken.getUsername();

        //调用数据库方法 获取  用户信息
        // 用户 不错在  可以抛出异常  UnKnownAccountException

        //根据 用户来构造 AuthenticationInfo 对象返回
        Object princeipal = username;

        //密码加密 后的 账号是 user  xxxx

        Object credentials = null;

        if ("user".equals(username)){

            credentials = "bac947aef187c26e7878bcc651dcd2e3";

        }
        if ("admin".equals(username)){

            credentials = "0ea9114a57ee221805a9cd4f1ce40663";

        }

        String realName = getName();

        /**
         *    princeipal   用户实体信息  可以是 usename  可以是数据表中的 实体对象
         *    credentials  密码
         *    加盐操作
         *    realName    reaml  对象对的name  调用父类的 getName()
         */
        //加盐操作
        ByteSource solt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(princeipal,credentials,solt,realName);

        return info;
    }


    public static void main(String[] args) {




    }

    /**
     * 授权操作
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }



}
