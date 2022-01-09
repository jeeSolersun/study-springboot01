package com.codeify.springboot01.designpatterns.singleton01;

/**
 * 单例模式--静态内部类形式
 *
 * @author codeify
 * @since 2021/08/21 15:32
 */
public class Singleton03 {
    private Singleton03() {

    }

    private static class Singleton03Inner { // 静态内部类
        private static final Singleton03 instance = new Singleton03();
    }

    public static Singleton03 getInstance() {
        return Singleton03Inner.instance;
    }
}
