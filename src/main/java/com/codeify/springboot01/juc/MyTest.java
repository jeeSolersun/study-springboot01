package com.codeify.springboot01.juc;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author codeify
 * @since 2023/07/14 00:11
 */
@Slf4j
public class MyTest {
    static final ThreadPoolExecutor threadPoolExecutor;
    static {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(100);
        threadPoolExecutor =
                new ThreadPoolExecutor(4, 400,0, TimeUnit.MILLISECONDS, queue, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int s = 1/0;
            log.info("stop");
        })
//                .exceptionally(throwable -> {
//                    log.info("error");
//                    return null;
//                })
                .join();
        log.info("main");
    }

    private static void test01() {
        log.info("start...");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("loop get future");
        int loop = 1000;
        List<CompletableFuture<Integer>> futures = new ArrayList<>(loop);
        for (int i = 0; i < loop; i++) {
            final int finalI = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return finalI;
            }, threadPoolExecutor);
            futures.add(future);
        }
        stopWatch.stop();
        stopWatch.start("execute allOf");
        List<Integer> resultList = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(res -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()))
                .exceptionally(exception -> {
                    log.error("exception", exception);
                    return new ArrayList<>();
                })
                .join();
        stopWatch.stop();
        log.info("stopWatch.prettyPrint() = " + stopWatch.prettyPrint(TimeUnit.SECONDS));
        log.info("end...");
        log.info("resultList = " + resultList);
    }
}
