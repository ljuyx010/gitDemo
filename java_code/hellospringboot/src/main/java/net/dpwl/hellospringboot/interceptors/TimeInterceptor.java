package net.dpwl.hellospringboot.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/6 15:53
 * 自定义一个拦截器，用来记录请求的处理时间
 */
public class TimeInterceptor implements HandlerInterceptor {
    LocalDateTime begin;
    // 前置方法，在控制器方法执行之前调用
    /**
     * 前置方法，在控制器方法执行之前调用
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器对象
     * @return true 表示继续处理，false 表示中断处理
     * @throws Exception 可能抛出的异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 记录请求开始的时间
        begin = LocalDateTime.now();
        // 把 begin 放到请求的属性中，方便后续的拦截器和控制器使用
        request.setAttribute("begin", begin);
        return true;
    }


    // 后置方法，在控制器方法执行之后调用
    /**
     * 后置方法，在控制器方法执行之后调用
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器对象
     * @param modelAndView 模型和视图对象
     * @throws Exception 可能抛出的异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 完成方法，在控制器方法执行完成之后调用
    /**
     * 完成方法，在控制器方法执行完成之后调用
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器对象
     * @param ex 异常对象
     * @throws Exception 可能抛出的异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // 记录请求结束的时间
        LocalDateTime endTime = LocalDateTime.now();
        // 计算请求的处理时间(toMillis毫秒)
        long processingTime = Duration.between(begin, endTime).toMillis();
        // 打印请求的处理时间
        System.out.println("请求 " + request.getRequestURI() + " 的处理时间为 " + processingTime + " 毫秒");
    }
}