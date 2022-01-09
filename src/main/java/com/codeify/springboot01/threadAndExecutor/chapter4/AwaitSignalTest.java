package com.codeify.springboot01.threadAndExecutor.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  * 设计模式之交替输出abc--使用wait/notify实现
 *
 * @author codeify
 * @since 2022/01/03 19:11
 */
@Slf4j
public class AwaitSignalTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        AwaitSignal awaitSignal = new AwaitSignal(5, lock);
        new Thread(() -> {
            log.debug("111");
            awaitSignal.print("a", conditionA, conditionB);
        }).start();
        new Thread(() -> {
            log.debug("222");
            awaitSignal.print("b", conditionB, conditionC);
        }).start();
        new Thread(() -> {
            log.debug("333");
            awaitSignal.print("c", conditionC, conditionA);
        }).start();
        TimeUnit.SECONDS.sleep(1);
        lock.lock();
        try {
            log.debug("main");
            conditionA.signal();
//        } catch (InterruptedException e) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class AwaitSignal {
    private int loopNumber;

    private ReentrantLock lock;

    public AwaitSignal(int loopNumber, ReentrantLock lock) {
        this.loopNumber = loopNumber;
        this.lock = lock;
    }

    public void print(String str, Condition current, Condition next) {
        lock.lock();
        try {
            for (int i = 0; i < loopNumber; i++) {
                current.await();
                System.out.print(str);
                next.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
