package com.codeify.springboot01.typeparameter;

/**
 * @author codeify
 * @since 2021/08/25 22:08
 */
public class BaseServiceImpl<T> implements BaseService<T>{
    @Override
    public void add(T t) {
        System.out.println("add() in BaseServiceImpl.class");
    }
}
