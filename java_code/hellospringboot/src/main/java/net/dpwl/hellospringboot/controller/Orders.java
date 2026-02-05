package net.dpwl.hellospringboot.controller;

import net.dpwl.hellospringboot.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/4 16:24
 */

@RestController
@RequestMapping("/orders")
public class Orders {
    //声明RestTemplate
    private final RestTemplate restTemplate;

    // 当bean没有无参构造函数的时候，spring将自动拿到有参构造函数，将其参数自动注入
    @Autowired
    public Orders(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // 测试方法
    @RequestMapping("/test")
    public String test() {
        // 需要远程调用orders服务的/test接口
        Result result = restTemplate.getForObject("http://localhost:8080/hello/world", Result.class);
        System.out.println(result);
        return "hello orders";
    }
}
