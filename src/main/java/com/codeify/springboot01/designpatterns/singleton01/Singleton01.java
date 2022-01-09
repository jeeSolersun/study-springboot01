package com.codeify.springboot01.designpatterns.singleton01;

/**
 * 单例模式--饿汉式，jvm保证实例唯一（jvm只会加载类一次到内存中)
 *
 * @author codeify
 * @since 2021/08/21 14:32
 */
public class Singleton01 {
    private static final Singleton01 instance = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if (instance == null)
            return null;
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton01.getInstance().hashCode())).start();
        }
    }
}
