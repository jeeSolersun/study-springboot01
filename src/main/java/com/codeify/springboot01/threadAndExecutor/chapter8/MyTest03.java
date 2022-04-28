package com.codeify.springboot01.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 测试自定义线程池
 *
 * @author codeify
 * @since 2022/04/26 01:29
 */
@Slf4j
public class MyTest03 {
    public static void main(String[] args) {
        MyBlockingQueue<Runnable> queue = new MyBlockingQueue<>(2);
        MyThreadPool myThreadPool =
                new MyThreadPool(2, 2, queue, 1000, TimeUnit.MILLISECONDS,
                        (taskQueue, task) -> {
                            // 当任务队列满时：
                            // 1、主线程一直等待put
//                            taskQueue.put(task);
                            // 2、主线程超时等待一定时间
//                            taskQueue.offer(task, 1000, TimeUnit.MILLISECONDS);
                            // 3、主线程啥也不干
                            // 4、主线自己运行
//                            task.run();
                            // 5、抛出异常
                            throw new RuntimeException("任务队列已满，不执行新的任务");
                        });
        for (int i = 0; i < 5; i++) {
            int iTmp = i;
            myThreadPool.execute(() -> {
                try {
                    log.debug("执行任务中。。。i = {}", iTmp);
                    Thread.sleep(1000 * 100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
