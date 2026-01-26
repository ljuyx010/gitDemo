package net.dpwl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/26 11:21
 */
@Configuration  // 1.配置类
@ComponentScan("net.dpwl.controller") // 2.扫描controller包
@EnableWebMvc //4.开启WebMvc配置,配置mvc相关的bean
public class SpringMVCConfig {
    // 3.配置非自定义的bena，配置文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(1024 * 1024 * 10);
        return multipartResolver;
    }

    // 配置简单的异常处理类
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        // 不管是什么异常，统一的响应一个友好页面
        resolver.setDefaultErrorView("/error.html");
        Properties mappings = new Properties(); // 配置异常类型和视图的映射关系
        mappings.setProperty("java.lang.RuntimeException", "/error.html"); //key 异常类型，value 视图名称
//        区分异常类型，根据不同的异常类型，可以跳转不同的视图
        resolver.setExceptionMappings(mappings);
        return resolver;
    }
}
