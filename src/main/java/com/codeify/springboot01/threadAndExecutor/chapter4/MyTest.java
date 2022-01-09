package com.codeify.springboot01.threadAndExecutor.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author codeify
 * @since 2022/01/07 23:09
 */
@Slf4j
public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("t1线程 await...");
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        t1.start();
//        Thread.sleep(1000*2);
        lock.lock();
        try {
            log.debug("通知t1线程");
            c1.signal();
//            t1.start();
        } finally {
            lock.unlock();
        }
    }
}
