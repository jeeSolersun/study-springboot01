package com.codeify.springboot01.juc.threadAndExecutor.chapter5;

import lombok.extern.slf4j.Slf4j;

/**
 * 可见性问题演示
 *
 * @author codeify
 * @since 2022/01/09 22:45
 */
@Slf4j
public class Demo01 {
    static boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while(true) {
                if (stop) {
                    break;
                }
            }
        }, "t1").start();

        Thread.sleep(2*1000);
        log.debug("停止t1线程。。。");
        stop = true;
    }
}
