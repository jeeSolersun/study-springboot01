package com.codeify.springboot01.juc.threadAndExecutor.chapter4;

import lombok.extern.slf4j.Slf4j;

/**
 * 同步模式之顺序控制--先输出2再输出1
 * 使用wait/notify实现
 *
 * @author codeify
 * @since 2022/01/03 18:38
 */
@Slf4j
public class Demo01 {
    static Object lock = new Object();
    // 满足条件
    static boolean t2Runned = false;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while (!t2Runned) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2Runned = true;
                lock.notify();
            }
        }, "t2").start();
    }
}
