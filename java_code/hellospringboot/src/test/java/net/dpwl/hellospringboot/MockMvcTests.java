package net.dpwl.hellospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/5 11:49
 */

@SpringBootTest  // 启动spring boot 应用
@AutoConfigureMockMvc // 专门用于做mockmvc的，由spring-test提供，依赖junit5
public class MockMvcTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMockMvc() throws Exception {
        // 发起一个get请求，请求路径为/hello，不依赖网络，直接把请求映射到Controller
        // 不依赖web服务，不需要启动web应用
        mockMvc.perform(
                // 发送get请求
                MockMvcRequestBuilders.get("/hello/world")
                .accept(MediaType.APPLICATION_JSON) //设置相应的文本类型
                // .param(name,value) 添加请求参数?name=value
           )
                // 响应断言 状态码为200 执行andDo内的操作
                .andExpect(status().isOk())
                // 响应断言 响应体中的data.id为1 执行andDo内的操作,如果不是1，会报错
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void postMockMvc() throws Exception {
        String userJson = "{\"id\":1,\"name\":\"混江龙\",\"age\":20}";
        // 发起一个get请求，请求路径为/hello，不依赖网络，直接把请求映射到Controller
        // 不依赖web服务，不需要启动web应用
        mockMvc.perform(
                        // 发送get请求
                        MockMvcRequestBuilders.post("/hello/world")
                                .accept(MediaType.APPLICATION_JSON) //设置相应的文本类型
                        // .param(name,value) 添加请求参数?name=value
                                .contentType(MediaType.APPLICATION_JSON) //设置请求的文本类型
                                .content(userJson) //设置请求体的内容
                )
                // 响应断言 状态码为200 执行andDo内的操作
                .andExpect(status().isOk())
                // 响应断言 响应体中的data.id为1 执行andDo内的操作,如果不是1，会报错
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
                .andDo(MockMvcResultHandlers.print());
    }

}
