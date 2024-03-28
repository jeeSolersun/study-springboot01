package com.codeify.springboot01.juc.threadAndExecutor.chapter5;

import lombok.extern.slf4j.Slf4j;

/**
 * t2.interrupt()之前对变量x的修改，对于其它线程对该变量x的读可见
 *
 * @author codeify
 * @since 2022/02/08 13:47
 */
@Slf4j
public class HappensBefore01 {
    static int x;

    public static void main(String[] args) {
        Thread t2 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) { // 不会清除打断标记
                    log.debug("t2.isInterrupted() = " + Thread.currentThread().isInterrupted());
                    log.debug("x = {}", x); // 可见
                    break;
                }
            }
        }, "t2");
        t2.start();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000 * 1);
                x = 10;
                t2.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

//        try {
//            t2.join();
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (true) {
            log.debug("t2.isInterrupted() = " + t2.isInterrupted() + ", isAlive = " + t2.isAlive());
            Thread.yield();
            if (t2.isInterrupted()) {
                log.debug("t2.isInterrupted() = " + t2.isInterrupted() + ", isAlive = " + t2.isAlive()); // true true
                break;
            }
        }
        log.debug("x = {}", x); // 可见
    }
}
