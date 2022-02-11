package com.codeify.springboot01.exercise;

import java.util.Scanner;

/**
 * @author codeify
 * @since 2022/01/10 21:30
 */
public class MyTest22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next1 = scanner.next();
        String next2 = scanner.next();
        String next3 = scanner.next();
        System.out.println(String.format("%s,%s,%s", next1, next2, next3));
    }
}
