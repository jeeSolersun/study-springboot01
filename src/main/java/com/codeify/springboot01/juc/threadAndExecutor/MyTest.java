package com.codeify.springboot01.juc.threadAndExecutor;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author codeify
 * @since 2021/12/27 23:18
 */
@Slf4j
public class MyTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            log.info("res : {}", 1/0);
        });
//        executorService.submit(() -> {
//            log.info("res : {}", 1/0);
//        });

        executorService.execute(() -> {
            log.info("execute again");
        });

    }

    private static void test01() {
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
