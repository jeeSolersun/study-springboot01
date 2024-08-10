package com.codeify.springboot01.dameng;

import com.codeify.springboot01.SpringSpringboot01Application;
import com.codeify.springboot01.entity.User;
import com.codeify.springboot01.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: codeify
 * @date: 2024/7/25 01:09
 */
@SpringBootTest
public class DamengDbTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void test() {
        User byId = userMapper.findById(1);
        System.out.println("byId = " + byId);
    }
}
