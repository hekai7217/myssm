package com.lx.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * create by hekai  2019-07-06
 *
 * @desc
 */
@Service
public class ShiroService {

    @RequiresRoles( value = {"admin"},logical = Logical.AND)
    public void testMethod(){

        Session session = SecurityUtils.getSubject().getSession();

        System.out.println(session.getAttribute("key"));

        System.out.println("testMethod, time: " + new Date());
    }

}
