package com.codeify.springboot01.service;

import com.codeify.springboot01.annotation.MyLog;
import org.springframework.stereotype.Service;

/**
 * @author codeify
 * @since 2024/02/26 17:34
 */
@Service
public class ComputerServiceImpl {
    @MyLog
    public void saveUser() {
        System.out.println("saveUser()调用了");
    }
}
