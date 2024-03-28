package com.codeify.springboot01.juc.threadAndExecutor.design_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * 保护性暂停
 * @author codeify
 * @since 2021/12/22 22:42
 */
@Slf4j
public class GuardedSuspensionTest {
    public static void main(String[] args) throws InterruptedException {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(() -> {
            String result = (String) guardedObject.get(2 * 1000);
            log.debug("result = " + result);
        }, "t1").start();
        log.debug("sleep");
        Thread.sleep(3*1000);
        new Thread(() -> {
            guardedObject.complete("我是msg");
        }, "t2").start();
    }
}

@Slf4j
class GuardedObject {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Object response;

    public synchronized Object get(long timeout) {
        log.debug("get调用");
        long begin = System.currentTimeMillis();
        long waste = 0;
        while (response == null) {
            waste = System.currentTimeMillis() - begin;
            long delay = timeout - waste;
            if (delay <= 0) {
                break;
            }
            try {
                this.wait(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    public synchronized void complete(Object response) {
        log.debug("complete调用");
        this.response = response;
//        this.notify();
        this.notifyAll();
    }
}
