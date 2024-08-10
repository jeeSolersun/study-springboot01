package com.codeify.springboot01.juc.threadAndExecutor;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author codeify
 * @since 2021/12/27 23:18
 */
@Slf4j
public class MyTest {
     private static ExecutorService executorService;

     static {
         executorService = Executors.newFixedThreadPool(10);
     }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    private static void test04() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("codeify", 1);
        Integer res = map.computeIfAbsent("codeify", key -> 2);
        System.out.println("res = " + res);
    }

    private static void test03() {
        int size = 1000_000;
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>(size);
        List<CompletableFuture<Void>> futureList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                String uuid = IdUtil.simpleUUID();
                AtomicInteger atomicInteger = map.computeIfAbsent(uuid, key -> new AtomicInteger());
                atomicInteger.incrementAndGet();
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        map.forEach((key, value) -> {
            int i = value.get();
            if (i > 1) {
                log.info("key = {}, value = {}", key, value);
            }
        });
        log.info("done!!!");
    }

    private static void test02() {
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
