package net.dpwl.hellospringboot.config;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/5 15:39
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置类
 * Spring Boot 4.x不再自动配置RestTemplate，需要手动创建Bean
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}