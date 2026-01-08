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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 17:32
 */
@Tag(name = "测试接口", description = "提供简单的测试接口和健康检查")
@RestController
@RequestMapping("/api")
public class TestController {

    /**
     * 最简单的测试接口
     */
    @Operation(summary = "测试接口", description = "返回一个简单的消息")
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
    @Operation(summary = "健康检查", description = "返回应用的健康状态")
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("version", "1.0.0");
        health.put("java", System.getProperty("java.version"));
        return health;
    }
}