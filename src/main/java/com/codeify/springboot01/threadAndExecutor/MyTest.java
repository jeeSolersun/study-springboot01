package com.codeify.springboot01.threadAndExecutor;

import java.util.Scanner;

/**
 * @author codeify
 * @since 2021/12/27 23:18
 */
public class MyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入number:");
            double number = scanner.nextDouble();
            for (int i = 0; i < 601; i++) {
                double result = (number / (10 * 60) - number / (60 * 15)) * i + (number/(10*60))*100;
                if (result == 300d) {
                    System.out.println("这批花共" + number + "，i=" + i);
                    break;
                }
            }

        }

    }
}
