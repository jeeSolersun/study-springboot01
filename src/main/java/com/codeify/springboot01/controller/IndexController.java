package com.codeify.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by sunhanbing on 2021/04/18 19:31
 */
@Controller
public class IndexController {

    @GetMapping(value ="/index4")
    @ResponseBody
    public String index(){

        return "hello, spring-security";
    }
}
