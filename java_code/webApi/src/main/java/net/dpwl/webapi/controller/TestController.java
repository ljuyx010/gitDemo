package net.dpwl.webapi.controller;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 17:32
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    /**
     * 最简单的测试接口
     */
    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "Hello Spring Boot 3!");
        result.put("status", "success");
        result.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return result;
    }

    /**
     * 健康检查端点
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("version", "1.0.0");
        health.put("java", System.getProperty("java.version"));
        return health;
    }
}