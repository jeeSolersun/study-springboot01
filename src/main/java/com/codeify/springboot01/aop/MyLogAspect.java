package com.codeify.springboot01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author codeify
 * @since 2024/02/26 17:37
 */
@Aspect
@Component
public class MyLogAspect {
    @Around("@annotation(com.codeify.springboot01.annotation.MyLog)")
    public Object saveLog(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        try {
            // todo 业务增强。。。
            System.out.println("保存日志到数据库before!!!");
            proceed = joinPoint.proceed();
            System.out.println("保存日志到数据库after!!!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
