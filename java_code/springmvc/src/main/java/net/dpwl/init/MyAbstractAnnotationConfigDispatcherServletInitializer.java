package net.dpwl.init;

import net.dpwl.config.SpringConfig;
import net.dpwl.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/26 14:25
 */
public class MyAbstractAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
//    提供spring容器的核心配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
//    提供springmvc容器的核心配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
//    提供springmvc容器的映射路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
