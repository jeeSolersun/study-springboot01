package com.codeify.springboot01.juc.threadAndExecutor.design_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * 两阶段中止模式
 *
 * @author codeify
 * @since 2021/12/24 21:36
 */
@Slf4j
public class TowPhaseTerminal {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (; ; ) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                log.debug("开始睡眠");
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    log.debug("t1的interrupt: {}", Thread.currentThread().isInterrupted()); // false
                    e.printStackTrace();
                    Thread.currentThread().interrupt(); // 2、捕获异常再次打上中断标记
                    log.debug("t1的interrupt: {}", Thread.currentThread().isInterrupted()); // true
                }
            }
        }, "t1");
        t1.start();
        try {
            Thread.sleep(4*1000);
            log.debug("打断t1");
            t1.interrupt(); // 1、中断t1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
