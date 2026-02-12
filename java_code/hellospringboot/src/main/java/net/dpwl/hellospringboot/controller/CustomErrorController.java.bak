package net.dpwl.hellospringboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.dpwl.hellospringboot.entity.Result;
import org.jspecify.annotations.Nullable;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.server.autoconfigure.ServerProperties;
import org.springframework.boot.webmvc.autoconfigure.error.AbstractErrorController;
import org.springframework.boot.webmvc.autoconfigure.error.ErrorViewResolver;
import org.springframework.boot.webmvc.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/10 14:17
 * 自定义错误信息控制器
 */
@Controller
@RequestMapping(value = "error")
@EnableConfigurationProperties({ServerProperties.class})
public class CustomErrorController extends AbstractErrorController {
    private final ErrorProperties errorProperties;

    public CustomErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, @Nullable List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
        this.errorProperties = errorProperties;
    }
    // 日志记录器
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    /**
     * 处理HTML错误请求
     * 加上异常日志记录
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(
            produces = {"text/html"}
    )
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = this.getStatus(request);
        //getErrorAttributeOptions可以动态的根据请求的MediaType返回不同的ErrorAttributeOptions
        //根据配置文件中server.error.include-exception=true来决定是否包含异常信息选项
        Map<String, Object> model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.getErrorAttributeOptions(request, MediaType.TEXT_HTML)));
        //记录异常日志,把异常的栈信息记录到异常日志中
        logger.error(model.get("trace").toString());
        response.setStatus(status.value());
        ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);
        return modelAndView != null ? modelAndView : new ModelAndView("error", model);
    }

    /**
     * 处理非HTML错误请求
     * 加上异常日志记录
     * @param request
     * @return Result
     */
    @RequestMapping
    @ResponseBody  //返回json格式的错误信息
    public Result error(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new Result(204, "no content");
        } else {
            //getErrorAttributeOptions可以动态的根据请求的MediaType返回不同的ErrorAttributeOptions
            //根据配置文件中server.error.include-exception=true来决定是否包含异常信息选项
            Map<String, Object> body = this.getErrorAttributes(request, this.getErrorAttributeOptions(request, MediaType.ALL));
            logger.error(body.get("trace").toString());
            Result result = new Result();
            result.setCode(body.get("status") == null ? 500 : Integer.parseInt(body.get("status").toString()));
            result.setMsg(body.get("message") == null ? status.getReasonPhrase() : body.get("message").toString());
            return result;
        }
    }

    protected ErrorAttributeOptions getErrorAttributeOptions(HttpServletRequest request, MediaType mediaType) {
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
        if (this.errorProperties.isIncludeException()) {
            options = options.including(new ErrorAttributeOptions.Include[]{ErrorAttributeOptions.Include.EXCEPTION});
        }

        if (this.isIncludeStackTrace(request, mediaType)) {
            options = options.including(new ErrorAttributeOptions.Include[]{ErrorAttributeOptions.Include.STACK_TRACE});
        }

        if (this.isIncludeMessage(request, mediaType)) {
            options = options.including(new ErrorAttributeOptions.Include[]{ErrorAttributeOptions.Include.MESSAGE});
        }

        if (this.isIncludeBindingErrors(request, mediaType)) {
            options = options.including(new ErrorAttributeOptions.Include[]{ErrorAttributeOptions.Include.BINDING_ERRORS});
        }

        options = this.isIncludePath(request, mediaType) ? options.including(new ErrorAttributeOptions.Include[]{ErrorAttributeOptions.Include.PATH}) : options.excluding(new ErrorAttributeOptions.Include[]{ErrorAttributeOptions.Include.PATH});
        return options;
    }

    protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
        boolean var10000;
        switch (this.getErrorProperties().getIncludeStacktrace()) {
            case ALWAYS -> var10000 = true;
            case ON_PARAM -> var10000 = this.getTraceParameter(request);
            case NEVER -> var10000 = false;
            default -> throw new IncompatibleClassChangeError();
        }

        return var10000;
    }

    protected boolean isIncludeMessage(HttpServletRequest request, MediaType produces) {
        boolean var10000;
        switch (this.getErrorProperties().getIncludeMessage()) {
            case ALWAYS -> var10000 = true;
            case ON_PARAM -> var10000 = this.getMessageParameter(request);
            case NEVER -> var10000 = false;
            default -> throw new IncompatibleClassChangeError();
        }

        return var10000;
    }

    protected boolean isIncludeBindingErrors(HttpServletRequest request, MediaType produces) {
        boolean var10000;
        switch (this.getErrorProperties().getIncludeBindingErrors()) {
            case ALWAYS -> var10000 = true;
            case ON_PARAM -> var10000 = this.getErrorsParameter(request);
            case NEVER -> var10000 = false;
            default -> throw new IncompatibleClassChangeError();
        }

        return var10000;
    }

    protected boolean isIncludePath(HttpServletRequest request, MediaType produces) {
        boolean var10000;
        switch (this.getErrorProperties().getIncludePath()) {
            case ALWAYS -> var10000 = true;
            case ON_PARAM -> var10000 = this.getPathParameter(request);
            case NEVER -> var10000 = false;
            default -> throw new IncompatibleClassChangeError();
        }

        return var10000;
    }

    protected ErrorProperties getErrorProperties() {
        return this.errorProperties;
    }
}
