package com.codeify.springboot01.exercise.aa;

import java.util.Scanner;

/**
 * @author codeify
 * @since 2022/01/10 01:14
 */
public class Demo06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = Integer.parseInt(s);
        int add = 2;
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
//                int random = (int)(Math.random()*10) + 1;
                
            }
            add++;
            System.out.println();
        }
    }
}
