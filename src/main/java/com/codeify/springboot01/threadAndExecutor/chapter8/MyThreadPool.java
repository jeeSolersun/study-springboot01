package com.codeify.springboot01.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 *
 * @author codeify
 * @since 2022/04/19 01:36
 */
@Slf4j
public class MyThreadPool {
    // 核心线程的数量
    private int coreSize;

    private int maxQueueSize;

    // 任务队列
    private MyBlockingQueue<Runnable> taskQueue;

    private long timeOut;

    private TimeUnit timeUnit;

    // 线程集合
    private Set<MyWorker> workSet;

    // 拒绝策略
    private RejectPolicy rejectPolicy;

    public MyThreadPool(int coreSize, int maxQueueSize, MyBlockingQueue<Runnable> taskQueue, long timeOut, TimeUnit timeUnit, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        workSet = new HashSet<>(coreSize);

        this.maxQueueSize = maxQueueSize;
        this.taskQueue = taskQueue;

        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task) {
        synchronized (workSet) {
            if (workSet.size() < coreSize) {
                MyWorker myWorker = new MyWorker(task); // 创建新的线程
                workSet.add(myWorker);
                log.debug("创建新的线程 worker = {}, task = {}", myWorker, task);
                myWorker.start(); // 启动线程
            } else {
//                taskQueue.put(task); // 线程集合已满，将任务添加到任务队列
                taskQueue.tryPut(task, rejectPolicy);
                log.debug("任务加到任务队列，task = {}", task);
            }
        }
    }

    class MyWorker extends Thread{
        private Runnable task;

        public MyWorker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null || (task = taskQueue.poll(timeOut, timeUnit)) != null) {
                try {
                    log.debug("执行中，task = {}", task);
                    task.run();
                } finally {
                    task = null;
                }
            }
            workSet.remove(this); // 线程结束运行，从线程集合中移除当前线程
            log.debug("线程被移除，worker = {}", this);
        }
    }
}

@FunctionalInterface
interface RejectPolicy<T> {
    void reject(MyBlockingQueue<T> taskQueue, T task);
}
