package com.codeify.springboot01.transactional;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author codeify
 * @since 2021/12/06 23:58
 */
public class UserServiceImpl {
    @Transactional
    public Map<String, Object> setUser() {
        return null;
    }



}
