package com.codeify.springboot01.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author codeify
 * @since 2023/04/24 01:00
 */
public class TestGeneric {
    public static void main(String[] args) {
        Type[] actualTypeArguments = ((ParameterizedType) Run1.class.getGenericSuperclass()).getActualTypeArguments();
        for (Type generic : actualTypeArguments) {
            Class clazz = (Class) generic;
            System.out.println("clazz = " + clazz);
        }
    }
}
