package com.codeify.springboot01.controller;

import com.codeify.springboot01.entity.User;
import com.codeify.springboot01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codeify
 * @since 2022/04/28 23:47
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable String id) {
        String myName = "hello";
        return userMapper.findById(Integer.valueOf(id));
    }
}
