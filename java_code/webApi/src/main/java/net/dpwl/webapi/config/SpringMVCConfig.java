package net.dpwl.webapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/23 09:25
 */
@Configuration //配置类注解
@ComponentScan("net.dpwl.webapi.controller") //组件扫描注解

public class SpringMVCConfig {

    @Bean
    public MultipartResolver mulitpartResolver(){
        MultipartResolver multipartResolver = new StandardServletMultipartResolver();
        return multipartResolver;
    }
}
