package com.codeify.springboot01.typeparameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author codeify
 * @since 2021/08/25 22:09
 */
//@Component
public class BaseAction<T> {
    @Autowired
    private BaseService<T> baseService;

    public void printBaseService() {
        System.out.println("printBaseService()");
        System.out.println(baseService);
    }
}
