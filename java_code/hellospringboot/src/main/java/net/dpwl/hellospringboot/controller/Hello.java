package net.dpwl.hellospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/30 16:01
 */
@RestController
@RequestMapping("/hello")
public class Hello {
    @RequestMapping("/world")
    public String world() {
        return "hello world";
    }
}
