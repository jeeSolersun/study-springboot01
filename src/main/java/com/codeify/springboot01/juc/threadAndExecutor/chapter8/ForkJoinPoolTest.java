package com.codeify.springboot01.juc.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author codeify
 * @since 2022/06/15 18:24
 * <p>
 * forkjoin线程池的简单使用：从1累加到5
 */
@Slf4j
public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        MyForkJoinTask task = new MyForkJoinTask(5);
        MyForkJoinTask02 task = new MyForkJoinTask02(1, 5);
        LocalDateTime start = LocalDateTime.now();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        try {
            Integer result = submit.get();
            log.info("result = {}", result);
            LocalDateTime end = LocalDateTime.now();
            long spend = Duration.between(start, end).toMillis();
            log.info("spend = {}", spend);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyForkJoinTask extends RecursiveTask<Integer> {
    private Integer num;

    public MyForkJoinTask(Integer num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if (num.equals(1)) {
            return 1;
        }
        MyForkJoinTask task = new MyForkJoinTask(num - 1);
        task.fork();
        return num + task.join();
    }
}

// 任务拆分优化
class MyForkJoinTask02 extends RecursiveTask<Integer> {
    private Integer start;
    private Integer end;

    public MyForkJoinTask02(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) == 1) {
            return start + end;
        }
        if (start != null && start.equals(end)) {
            return start;
        }
        Integer middle = (start + end) / 2;
        MyForkJoinTask02 task1 = new MyForkJoinTask02(start, middle);
        MyForkJoinTask02 task2 = new MyForkJoinTask02(middle + 1, end);
        task1.fork();
        task2.fork();
        return task1.join() + task2.join();
    }
}