package com.codeify.springboot01.threadAndExecutor.chapter6;

/**
 * @author codeify
 * @since 2022/02/10 14:57
 */
public class Demo01 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.getMsg();
    }
}
class Apple {
    static void getMsg() {
        System.out.println("hello");
    }
}