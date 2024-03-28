package com.codeify.springboot01.juc.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author codeify
 * @since 2022/05/03 18:46
 */
@Slf4j
public class ExecutorsTest {
    public static void main(String[] args) {
//        new ThreadPoolExecutor()
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        executorService.execute();
        boolean interrupted = Thread.interrupted();
    }
}
