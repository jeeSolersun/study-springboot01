package com.codeify.springboot01.juc.threadAndExecutor.chapter5;

import lombok.extern.slf4j.Slf4j;

/**
 * balking模式（犹豫模式）
 *
 * @author codeify
 * @since 2022/01/23 16:59
 */
public class Demo02 {
    public static void main(String[] args) {
        BalkingPattern balkingPattern = new BalkingPattern();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                balkingPattern.init();
            }).start();
        }
    }
}
@Slf4j
class BalkingPattern {
    static boolean initial =  false;

    public void init() {
        synchronized (BalkingPattern.class) {
            if (initial) {
                return;
            }
            initial = true;
        }
        doSomething();
    }

    public void doSomething() {
        log.debug("doSomething");
    }
}
