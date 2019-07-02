package com.hk.demo01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
@SpringBootTest(classes = Demo01Application.class)
//测试 环境 使用  ApplicationContext 加入 webApplicationContext
@WebAppConfiguration
public class Demo01ApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void init(){

        //通过上下文 wac 创建 mockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void getMsg() throws Exception{

        /**
         * 1、mockMvc.perform执行一个请求。
         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
         * 3、ResultActions.param添加请求传值
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 5、ResultActions.andReturn表示执行完成后返回相应的结果。
         */

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/demo") //构建get 请求
                        .param("name", "zhangsan") // 请求参数
        ).andDo(MockMvcResultHandlers.print()) // 结果处理器  输出相应结果
                .andReturn();  // 返回执行结果

        //返回相应码
        int status = mvcResult.getResponse().getStatus();

        Assert.assertEquals(200,status);
        // 返回 结果内容
        String contentAsString = mvcResult.getResponse().getContentAsString();

        Assert.assertEquals("hello zhangsan",contentAsString);
    }

    @Test
    public void getUpdate() throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/demo/3"))

                .andDo(MockMvcResultHandlers.log()).andReturn();

        int status = mvcResult.getResponse().getStatus();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        System.out.println("status :" + status);
        System.out.println("contentAsString :" + contentAsString);
    }
}


