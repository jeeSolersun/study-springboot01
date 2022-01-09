package com.codeify.springboot01.stringTest;

import java.util.Locale;

/**
 * @author codeify
 * @since 2021/09/04 22:40
 */
public class StringDemo01 {
    public static void main(String[] args) {
//        System.out.println(String.format("hello:%%", 22, 33));
//        System.out.println(String.format("%b", 0));
//        System.out.println(String.format("%f", 22d));
//        System.out.println(String.format("%2e", 97f));
//        System.out.println(String.format("%n222", 22));
        /*System.out.println(String.format("%-10d", 12));
        System.out.println(String.format("% 10d", 12));
        System.out.println(String.format("%010d", 12));
        System.out.println(String.format("%,10d", 12));
        System.out.println(String.format("%(10d", 12));*/
        System.out.println(String.format("%2$s###%1$s", 2, 3));
    }
}
