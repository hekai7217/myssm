package com.lx.test;

import com.lx.bean.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * create by hekai  2019-06-26
 *
 * @desc
 *    Controller  测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMockMvc {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void init(){

        // 初始化 mockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void demo01() throws Exception {

        ResultActions perform = mockMvc.perform(get("/itemList.do"));

        MvcResult mvcResult = perform.andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();

        List<Item> list = (List<Item>) modelAndView.getModelMap().get("list");

        list.forEach(e-> System.out.println(e));

    }



}
