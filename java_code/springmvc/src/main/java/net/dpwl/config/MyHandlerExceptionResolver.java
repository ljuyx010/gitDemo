package net.dpwl.config;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/26 17:29
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView view = new ModelAndView();
        view.setViewName("/error.html");
        //  前后端分离开发，响应json格式的字符串{“code”:0,"msg":"error"}
        String resultJson="{“code”:0,\"msg\":\"error\"}";
        try {
            httpServletResponse.getWriter().write(resultJson);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
}
