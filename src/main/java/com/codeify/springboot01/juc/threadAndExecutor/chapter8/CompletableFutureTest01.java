package com.codeify.springboot01.juc.threadAndExecutor.chapter8;

import com.codeify.springboot01.entity.Phone;

/**
 * @author codeify
 * @since 2022/08/07 23:40
 */
public class CompletableFutureTest01 {
    public static void main(String[] args) {
        Phone aa = new Phone(1, "aa");
        Phone bb = new Phone(1, "aa");
        System.out.println("aa.hashCode() = " + aa.hashCode());
        System.out.println("bb.hashCode() = " + bb.hashCode());

        Phone cc = new Phone(1, "cc");
        System.out.println("cc.hashCode() = " + cc.hashCode());
//        System.out.println("Integer.toBinaryString(31) = " + Integer.toBinaryString(31)); // 11111
        char a = 'a';
        System.out.println("(int)a = " + (int)a);
        int s = a + 1;
        System.out.println("s = " + s);
    }
}
