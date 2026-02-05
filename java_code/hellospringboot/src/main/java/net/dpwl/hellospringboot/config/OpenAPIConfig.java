package net.dpwl.hellospringboot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI配置类（替代旧的SwaggerConfig）
 * 使用springdoc-openapi与Spring Boot 4.x兼容
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI createOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot OpenAPI")
                        .description("这是一个基于Spring Boot整合OpenAPI 3.0的API文档")
                        .version("1.0")
                        .license(new License()
                                .name("MIT License")
                                .url("https://mit-license.org/")
                        )
                        .contact(new Contact()
                                .name("混江龙")
                                .url("https://www.dpwl.net/")
                                .email("dpwl@dpwl.net")
                        )
                );
    }
}