package com.codeify.springboot01.juc.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author codeify
 * @since 2022/05/07 01:48
 */
@Slf4j
public class TimerAndScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        log.debug("start...");
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.debug("task1");
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 500, 1000, TimeUnit.MILLISECONDS);
//        scheduledExecutorService.schedule();
//        scheduledExecutorService.scheduleWithFixedDelay();
    }
}
