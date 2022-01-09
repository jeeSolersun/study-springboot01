package com.codeify.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringSpringboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSpringboot01Application.class, args);
    }

}
