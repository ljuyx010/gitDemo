package net.dpwl.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/26 11:51
 */
public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigWebApplicationContext {
    public MyAnnotationConfigWebApplicationContext() {
        // 注册SpringMVCConfig配置类，从而加载spring组件扫描
        super.register(SpringMVCConfig.class);
    }
}
