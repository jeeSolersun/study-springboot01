package com.codeify.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringSpringboot01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringSpringboot01Application.class, args);
//        ComputerServiceImpl bean = context.getBean(ComputerServiceImpl.class);
//        bean.saveUser();
//
//        System.out.println("bean = " + bean);
//        System.out.println("bean.getClass() = " + bean.getClass());
    }

}
