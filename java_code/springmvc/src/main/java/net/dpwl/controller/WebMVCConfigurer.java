package net.dpwl.controller;

import net.dpwl.interceptors.MyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/26 11:40
 */
@Component
public class WebMVCConfigurer  implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 开启默认的servlet处理,将静态资源的请求转发给默认的servlet处理
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义的拦截器,并指定拦截的路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
