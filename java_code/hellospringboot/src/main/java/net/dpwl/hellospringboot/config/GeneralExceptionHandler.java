package net.dpwl.hellospringboot.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/10 15:47
 * @ControllerAdvice 配合 `@ExceptionHandler` 实现全局异常处理
 */
@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Exception ex,
                                        HandlerMethod handler)
    {
        System.out.println("全局异常处理");
//        如果当前请求是ajax就返回json
//        1.根据用户请求的处理方法，是否是一个返回json的处理费方法
//        RestController restController = handler.getClass().getAnnotation(RestController.class); // 获得类上面的RestController注解
//        ResponseBody responseBody = handler.getMethod().getAnnotation(ResponseBody.class); // 获得方法上面的ResponseBody注解
//        if (restController != null && responseBody != null) { // 是一个返回json的处理方法
//        }

//        2.可以更加请求头中的content-type是否包含"application/json"来判断是否是ajax请求
        if(request.getHeader("content-type").contains("application/json")){
            // 是一个ajax请求,可以直接输出json,或者集成jackson等框架来输出json
//            response.getWriter().write("{'code':500,'msg':'服务器异常'}");
//            集成jackson的方式来输出json
            ModelAndView modelAndView = new ModelAndView();
            // 通常会根据不同的异常返回不同的编码
            modelAndView.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            modelAndView.addObject("message", ex.getMessage());
            return modelAndView;
        }else {
            // 不是一个ajax请求,可以返回一个错误页面
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("ex", ex);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            System.out.println(sw.toString()); // 日志记录
            return  modelAndView;
        }
    }

}
