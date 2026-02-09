package net.dpwl.hellospringboot.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/9 16:18
 * 国际化工具类
 */
public class LanguageUtil {
    private static ResourceBundleMessageSource messageSource;
    private static HttpServletRequest request;

    /**
     * 获取国际化资源属性
     * @param code
     * @param args
     * @return
     */
    public static String getMessage(String code,String... args) {
        return  messageSource.getMessage(code, args, request.getLocale());
    }
    @Autowired
    public void setMessageSource(ResourceBundleMessageSource messageSource) {
        LanguageUtil.messageSource = messageSource;
    }
    @Autowired
    public static void setRequest(HttpServletRequest request) {
        LanguageUtil.request = request;
    }
}
