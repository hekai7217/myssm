package com.lx.test;

import com.lx.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * create by hekai  2019-06-24
 *
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestService {

    @Autowired
    private ItemService itemService;

    @Test
    public void demo01(){
        itemService.queryItemList().forEach(e-> System.out.println(e));
    }
}
