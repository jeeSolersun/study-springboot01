package com.codeify.springboot01.juc.threadAndExecutor.chapter6;

import java.util.ArrayList;

/**
 * 账户接口类
 *
 * @author codeify
 * @since 2022/03/13 15:13
 */
public interface Account {
    // 开启1000个线程调用withDraw方法
    public static void demo(Account account) {
        long start = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                account.withDraw(10);
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("stop - start = " + (stop - start));
        System.out.println("account.getBalance() = " + account.getBalance());
    }
    int getBalance();

    void withDraw(int amount);
}
