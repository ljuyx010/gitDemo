package net.dpwl.hellospringboot.aspect;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/12 11:45
 * 日志切面类
 */
@Aspect  // 切面类
@Component // 组件类
public class LogAspect {
    // slf4j日志类
    Logger log=LoggerFactory.getLogger(LogAspect.class);
    //环绕通知
    //execution 传入切点表达式
//    * net.dpwl.hellospringboot.controller.*.*(..))"+"@annotation(Tag)"
//    *表示返回任意值，net.dpwl.hellospringboot.controller包下*表示所有的类，*表示所有的方法（..）表示所有的参数
//    @annotation(Operation)表示只有标注了Operation注解的方法才会被拦截
    @Around("execution(* net.dpwl.hellospringboot.controller.*.*(..)) &&"+"@annotation(operation)")
    //joinPoint 连接点对象，用于调用目标方法
    //operation 操作对象，用于获取注解中的值
    public Object logAround(ProceedingJoinPoint joinPoint, Operation operation) throws Throwable {
        System.out.println("环绕通知开始");
        StringBuilder loginfo=new StringBuilder("用户访问了："); //`日志信息字符串
        Class<?> controller = joinPoint.getThis().getClass(); //获取当前控制器
        Tag tag = controller.getAnnotation(Tag.class); // 获取控制器上的Tag注解
        if (tag != null) {
            loginfo.append(tag.name()+"-");
        }
        loginfo.append(operation.summary()); //operation.summary() 表示获取注解中的值
        log.info(loginfo.toString()); // 打印日志信息
        Object result = joinPoint.proceed();
        System.out.println("环绕通知结束");
        return result;
    }
}
