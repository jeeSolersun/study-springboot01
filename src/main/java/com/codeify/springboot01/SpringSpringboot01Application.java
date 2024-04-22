package com.codeify.springboot01;

import com.codeify.springboot01.entity.User;
import com.codeify.springboot01.service.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan()
public class SpringSpringboot01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringSpringboot01Application.class, args);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.test01();
    }

    private static void test02(UserServiceImpl userService) {
    /*List<User> users = getUsers();
    boolean b = userService.saveBatch(users);
    System.out.println("b = " + b);*/
        userService.test01();
    }

    private static List<User> getUsers() {
        List<User> codeify = IntStream.range(0, 5).mapToObj(val -> new User(null, "codeify", 22, 100))
                .collect(Collectors.toList());
        return codeify;
    }

}
