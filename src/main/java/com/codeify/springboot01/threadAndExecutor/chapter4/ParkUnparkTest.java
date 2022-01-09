package com.codeify.springboot01.threadAndExecutor.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * 设计模式之交替输出abc--使用wait/notify实现
 *
 * @author codeify
 * @since 2022/01/07 23:48
 */
@Slf4j
public class ParkUnparkTest {
    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) {
//        log.debug("t1: {}, t2: {}, t3: {}", t1, t2, t3);
        ParkUnpark parkUnpark = new ParkUnpark(5);
//        Thread t1 = null, t2 = null, t3 = null;
        t1 = new Thread(() -> {
            parkUnpark.print("a", t2);
        });
        t2 = new Thread(() -> {
            parkUnpark.print("b", t3);
        });
        t3 = new Thread(() -> {
            parkUnpark.print("c", t1);
        });
        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t1);
    }
}

class ParkUnpark {
    private int loopNumber;

    public ParkUnpark(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String str, Thread thread) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(thread);
        }
    }
}
