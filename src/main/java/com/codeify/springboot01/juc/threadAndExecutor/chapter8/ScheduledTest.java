package com.codeify.springboot01.juc.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 任务调度线程池定时执行任务：每周4下午16:00:00执行任务
 *
 * @author codeify
 * @since 2022/05/14 22:25
 */
@Slf4j
public class ScheduledTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        LocalDateTime now = LocalDateTime.now();
        // 本周星期四
        LocalDateTime targetTime = now.withHour(18).withMinute(0).withSecond(30).withNano(0).with(DayOfWeek.THURSDAY);
        if (now.compareTo(targetTime) > 0) { // 当前时间大于本周星期四
            targetTime = targetTime.plusDays(7); // 下周星期四 = 本周星期四 + 7天
        }
        //
        long initialDelay = Duration.between(now, targetTime).toMillis();
        // 时间周期为7天
        long period = 1000 * 60 * 60 * 24 * 7;
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.info("hello");
        }, initialDelay, period, TimeUnit.MILLISECONDS);
    }
}
