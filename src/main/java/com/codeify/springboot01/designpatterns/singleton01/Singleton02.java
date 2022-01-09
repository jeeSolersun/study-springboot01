package com.codeify.springboot01.designpatterns.singleton01;

/**
 * 单例模式（双重校验锁）
 *
 * @author codeify
 * @since 2021/08/21 14:53
 */
public class Singleton02 {
    private static volatile Singleton02 instance; // 添加volatile关键字，禁止编译器指令重排序

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton02.class) {
                if (instance == null) {
                    instance = new Singleton02();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton02.getInstance().hashCode())).start();
        }
    }
}
