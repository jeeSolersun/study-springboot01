package com.codeify.springboot01.designpatterns.singleton01;

/**
 * 单例模式--enum式（可以防止反序列化）
 *
 * @author codeify
 * @since 2021/08/21 17:20
 */
public enum Singleton04 {
    INSTANCE(1);

    private final int value;

    private Singleton04(int value) { // enum的构造方法（默认private）
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void printMsg() {
        System.out.println("message from Singleton04.class");
    }

}
