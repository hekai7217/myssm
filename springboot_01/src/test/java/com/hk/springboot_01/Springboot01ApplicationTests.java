package com.hk.springboot_01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class Springboot01ApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Test
    public void testPut() throws Exception{

        //初始化操作
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        //设置请求操作

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/put").
                param("id", "33")).andDo(

                MockMvcResultHandlers.print()

        ).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        System.out.println("content:" + content);
    }

    @Test
    public void testDel() throws Exception{

        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/del/3")).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        System.out.println("context:" + content);

    }

}
