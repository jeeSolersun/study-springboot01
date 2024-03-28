package com.codeify.springboot01.juc.threadAndExecutor.chapter6;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author codeify
 * @since 2022/02/26 18:03
 */
@Slf4j
public class Demo02 {
    public static void main(String[] args) {
        MyAdder myAdder = new MyAdder();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                myAdder.add(1);
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.debug("base = {}", myAdder.getBase().get());

    }
}

class MyAdder {
//    private Long base = 0L;

    private AtomicLong base = new AtomicLong(0L);

    public MyAdder() {
    }

    public void add(long num) {
        // 1、通过加锁的方式实现
//        synchronized (this) {
//            this.base += num;
//        }
        // 2、通过AtomicLong实现即cas实现
        long prev = base.get();
        while (true) {
            if (base.compareAndSet(prev, prev + 1)) {
                break;
            }
        }
    }

    public AtomicLong getBase() {
        return base;
    }

    public void setBase(AtomicLong base) {
        this.base = base;
    }
}
