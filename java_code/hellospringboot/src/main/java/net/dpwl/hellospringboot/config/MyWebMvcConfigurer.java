package net.dpwl.hellospringboot.config;

import net.dpwl.hellospringboot.interceptors.TimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/6 16:11
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
    *   添加视图控制器
    *   作用是：注册简单的视图控制器，避免为简单页面创建专门的控制器类*
     *   它用于将 URL 路径直接映射到视图名称，而不需要经过业务逻辑处理。
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 将根路径映射到index页面
        registry.addViewController("/").setViewName("index");
        // 永久重定向（301）
        registry.addRedirectViewController("/old-url", "/new-url")
                .setStatusCode(HttpStatus.MOVED_PERMANENTLY);

        // 临时重定向（302）
        registry.addRedirectViewController("/temp", "/new-location")
                .setStatusCode(HttpStatus.FOUND);

        // 重定向并保留查询参数
        registry.addRedirectViewController("/search", "/new-search")
                .setKeepQueryParams(true);
    }

    /**
     * 配置拦截器
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加时间拦截器，拦截所有请求
        registry.addInterceptor(new TimeInterceptor()) //添加拦截器TimeInterceptor
                .addPathPatterns("/**")  // 设置拦截映射规则，/**拦截所有
                .excludePathPatterns("/static/**"); // 排除拦截映射规则，静态目录下的请求全排除
        // 添加国际化拦截器，拦截所有请求，根据MyMvcAutoConfiguration自定义localeResolver方法获取cookies的locale参数，来切换语言
        registry.addInterceptor(new LocaleChangeInterceptor())
                .excludePathPatterns("/**");
    }

    /**
     *  支持跨域请求处理
     *  全局CORS配置
     *  在方法上添加@CrossOrigin("http//localhost:8081")注解，可以指定单个方法支持跨域请求(不配置url就所有来源都能跨域请求)
     * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 映射服务器中那些http接口运行跨域请求
                .allowedOrigins("http//localhost:8081")  // 配置那些来源有权限跨域请求,避免跨域攻击
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 配置允许跨域请求的请求方法
    }


}
