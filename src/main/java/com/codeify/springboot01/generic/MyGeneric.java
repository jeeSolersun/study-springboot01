package com.codeify.springboot01.generic;

/**
 * @author codeify
 * @since 2023/04/24 00:18
 */
public abstract class MyGeneric<R, T> {
    public abstract R run(T t);
}
