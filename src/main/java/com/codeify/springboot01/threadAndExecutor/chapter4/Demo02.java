package com.codeify.springboot01.threadAndExecutor.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * 同步模式之顺序控制--先输出2再输出1
 * 使用park/unpark实现
 *
 * @author codeify
 * @since 2022/01/03 18:45
 */
@Slf4j
public class Demo02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1");
        }, "t1");
        Thread t2 = new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(t1);
        }, "t2");
        t1.start();
        t2.start();
    }
}
