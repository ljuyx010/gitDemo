package net.dpwl.webapi.config;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 13:54
 */
import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot3.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.util.Utils;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.servlet.*;
import java.io.IOException;

@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(DruidDataSourceAutoConfigure.class)
@ConditionalOnProperty(
        name = "spring.datasource.druid.stat-view-servlet.enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class DruidAdRemovalConfig {
    // Filter注册Bean定义
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FilterRegistrationBean<Filter> removeDruidAdFilterRegistrationBean(DruidStatProperties properties) {
        // 获取:ml-search-more[StatViewServlet]{text="StatViewServlet"}的URL模式，默认为"/druid/*"
        String pattern = properties.getStatViewServlet().getUrlPattern() != null
                ? properties.getStatViewServlet().getUrlPattern()
                : "/druid/*";
        // 构造common.js的URL模式，如"/druid/js/common.js"
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");

        // 创建Filter实例
        Filter filter = new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
                // 初始化方法，可留空
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                    throws IOException, ServletException {
                // 先放行请求，再处理响应
                chain.doFilter(request, response);

                // 重置响应缓冲区，避免响应头冲突
                response.resetBuffer();

                // 从资源中读取common.js内容
                String text = Utils.readFromResource("support/http/resources/js/common.js");

                // 移除广告内容：替换或删除广告相关的HTML或JavaScript
                // 方法1：使用正则表达式匹配并移除广告标签（如包含"banner"的<a>标签）
                text = text.replaceAll("<a.*?banner\"></a><br/>", "");
                // 方法2：直接替换广告函数调用（如this.buildFooter()）
                // text = text.replace("this.buildFooter();", "");

                // 将修改后的内容写入响应
                response.getWriter().write(text);
            }

            @Override
            public void destroy() {
                // 销毁方法，可留空
            }
        };

        // 配置FilterRegistrationBean
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }
}

