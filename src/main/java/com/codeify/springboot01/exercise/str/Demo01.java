package com.codeify.springboot01.exercise.str;

import java.util.Scanner;

/**
 * @author codeify
 * @since 2022/06/19 14:24
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(;;) {
            float nextFloat = scanner.nextFloat();
            double ceil = Math.round(nextFloat);
            System.out.println((int) ceil);
        }

    }
}
