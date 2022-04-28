package com.codeify.springboot01.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author codeify
 * @since 2022/04/09 00:53
 */
@Slf4j
public class MyTest02 {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
//        new ThreadPoolExecutor(, )
//        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 2, 1000 * 60, TimeUnit.MILLISECONDS, queue);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000*2);
                    log.debug("hello");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
