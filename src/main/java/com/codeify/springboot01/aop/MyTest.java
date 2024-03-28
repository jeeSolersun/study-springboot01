package com.codeify.springboot01.aop;

import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.*;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codeify
 * @since 2023/08/28 23:51
 */
public class MyTest {
    public static void main(String[] args) {
        List<DefaultPointcutAdvisor> list = new ArrayList<>();
        AspectInstanceFactory aspectInstanceFactory = new SingletonAspectInstanceFactory(new Aspect());
        Method[] methods = Aspect.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                String expression = method.getAnnotation(Before.class).value();
                pointcut.setExpression(expression);
                AspectJMethodBeforeAdvice advice = new AspectJMethodBeforeAdvice(method, pointcut, aspectInstanceFactory);
//                AspectJAfterAdvice
//                AspectJAroundAdvice
//                AspectJAfterReturningAdvice
//                AspectJAfterThrowingAdvice
                DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
                list.add(advisor);
            }
        }
        for (DefaultPointcutAdvisor defaultPointcutAdvisor : list) {
            System.out.println(defaultPointcutAdvisor);
        }
    }

    static class Aspect {
        @Before("execution(* foo)")
        public void before() {
            System.out.println("before1...");
        }

        @Before("execution(* foo)")
        public void before2() {
            System.out.println("before2...");
        }
    }
}
