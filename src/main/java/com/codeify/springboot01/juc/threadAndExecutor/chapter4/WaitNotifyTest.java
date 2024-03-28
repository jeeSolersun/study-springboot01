package com.codeify.springboot01.juc.threadAndExecutor.chapter4;

/**
 * 设计模式之交替输出abc--使用wait/notify实现
 * @author codeify
 * @since 2022/01/03 18:51
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(5, 1);
        new Thread(() -> {
            waitNotify.print("a", 1, 2);
        }, "t1").start();
        new Thread(() -> {
            waitNotify.print("b", 2, 3);
        }, "t2").start();
        new Thread(() -> {
            waitNotify.print("c", 3, 1);
        }, "t3").start();
    }
}

class WaitNotify {
    private int loopNumber;

    private int flag;

    public WaitNotify(int loopNumber, int flag) {
        this.loopNumber = loopNumber;
        this.flag = flag;
    }

    public void print(String str, int waitFlag, int nextFlag) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
