package com.codeify.springboot01.typeparameter;

/**
 * @author codeify
 * @since 2021/08/25 22:07
 */
public interface BaseService<T> {
    void add(T t);
}
