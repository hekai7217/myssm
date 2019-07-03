package com.lx;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {

//        BasicConfigurator.configure();

        //通过 工厂 拿到  SecurityManager
        // 加载配置文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //单例 获取管理器
        SecurityManager securityManager = factory.getInstance();
        // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.  That is outside the scope of this simple quickstart, so/
        // we'll just do the bare minimum so you can continue to get a feel
        // for things.
        // 设置
        SecurityUtils.setSecurityManager(securityManager);
        // Now that a simple Shiro environment is set up, let's see what you can do:
        // get the currently executing user:
        // 获取当前的  sub
        Subject currentUser = SecurityUtils.getSubject();

        // se项目 也可以获取 session
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("=====session 中 可以 获取 value -----Retrieved the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        // 登录的操作
        if (!currentUser.isAuthenticated()) {
            // 用户名 登录
            UsernamePasswordToken token = new UsernamePasswordToken("scott", "tiger");
            // 记住我
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("====没有用户账号---->There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("====密码不对-----> Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("账号锁定了----The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }
        //say who they are:
        //print their identifying principal (in this case, a username):

        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
        //test a role:
        // 测试 当前的用户 是否有这个角色
        if (currentUser.hasRole("roles1")) {
            log.info("======有这个角色 May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }
        //test a typed permission (not instance-level)
        // 测试 当前用户 是否 有这个行为
        if (currentUser.isPermitted("roles1:买衣服")) {
            log.info("======买衣服 You may use a 买衣服 ring.  Use it wisely.");
        } else {
            log.info("======Sorry, lightsaber rings are for schwartz masters only.");
        }
        //a (very powerful) Instance Level permission:
        // 测试 当前用户 是否 有这个行为 (更加具体的行为)
        if (currentUser.isPermitted("user:update:stu")) {
            log.info("======> 细致行为 ---You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }
        //all done - log out!
        // 当前用注销
        currentUser.logout();
        System.exit(0);

    }
}
