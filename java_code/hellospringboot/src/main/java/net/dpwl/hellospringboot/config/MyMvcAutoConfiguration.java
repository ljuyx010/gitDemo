package net.dpwl.hellospringboot.config;

import org.springframework.boot.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/6 15:32
 * 自定义的Mvc自动配置类，用于配置一些默认的Bean，比如HiddenHttpMethodFilter
 */

@Configuration
public class MyMvcAutoConfiguration {
    /**
     * 配置HiddenHttpMethodFilter，用于处理POST请求中的隐藏方法（如PUT、DELETE等）
     * @return OrderedHiddenHttpMethodFilter实例
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        // springMv 中默认的 OrderedHiddenHttpMethodFilter 类，不存在HiddenHttpMethodFilter才会自动配置，
        // 我们自定义的配置类返回了HiddenHttpMethodFilter类，所以Spring mvc 不会自动配置HiddenHttpMethodFilter类，
        // 我们自定义的这个就会自动加载，然后可以实现一些我们想要的功能，
        // 比如我们可以在POST请求中添加一个隐藏字段_method，然后在Controller中根据这个字段来判断是PUT还是DELETE请求
        return new OrderedHiddenHttpMethodFilter();
    }
}
