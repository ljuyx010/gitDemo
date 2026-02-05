package net.dpwl.hellospringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/30 16:01
 */
@Tag(name = "欢迎页面", description = "欢迎页面API")
@RestController
@RequestMapping("/hello")
public class Hello {
    /**
     * 欢迎页面
     * @return 欢迎页面字符串
     */
    @Operation(summary = "欢迎页面", description = "返回欢迎页面字符串")
    @RequestMapping("/world")
    public String world() {
        return "hello world hujianglong11111";
    }
}
