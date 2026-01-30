package net.dpwl.config;

import com.sun.net.httpserver.Authenticator;
import net.dpwl.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/1/28 15:20
 */
public class GlobalExceptionHandler {

    @ExceptionHandler(value=RuntimeException.class)
    public ModelAndView runtimeExceptionResolverMethod(RuntimeException e) {
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error.html");
        return modelAndView;
    }


    @ExceptionHandler(value=IOException.class)
    @ResponseBody
    public Result ioExceptionResolverMethod(IOException e) {
        System.out.println(e.getMessage());
        Result result = new Result();
        result.setCode(500);
        result.setMsg("io异常");
        return result;
    }

}
