package com.codeify.springboot01.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/**
 * @author codeify
 * @since 2023/09/19 18:15
 */
public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
//        RequestMappingHandlerMapping handlerMapping = context.getBean(RequestMappingHandlerMapping.class);
        RequestMappingHandlerAdapter handlerAdapter = context.getBean(RequestMappingHandlerAdapter.class);
        System.out.println("handlerAdapter = " + handlerAdapter);
        List<HandlerMethodReturnValueHandler> returnValueHandlers = handlerAdapter.getReturnValueHandlers();
        for (HandlerMethodReturnValueHandler returnValueHandler : returnValueHandlers) {
            System.out.println(returnValueHandler);
        }
    }
}
