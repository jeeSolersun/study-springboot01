package com.codeify.springboot01.juc.threadAndExecutor.chapter8;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义任务队列
 *
 * @author codeify
 * @since 2022/04/15 00:03
 */
public class MyBlockingQueue<T> {
    private int size; // 队列的容量

    private ArrayDeque<T> queue; // 队列

    private ReentrantLock lock = new ReentrantLock();

    private Condition fullWaitSet = lock.newCondition();

    private Condition emptyWaitSet = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>(size);
    }

    // 不带超时时间的put方法
    public void put(T t) {
        lock.lock();
        try {
            while (queue.size() >= size) {
                fullWaitSet.await();
            }
            queue.addLast(t);
            emptyWaitSet.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 带超时时间的put方法
    public void offer(T t, long timeOut, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeOut);
            while (queue.size() >= size) {
                if (nanos <= 0) {
                    return;
                }
                nanos = fullWaitSet.awaitNanos(nanos);
            }
            queue.addLast(t);
            emptyWaitSet.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 不带超时时间的获取任务的方法
    public T take() {
        lock.lock();
        try {
            while (queue.size() <= 0) {
                // 不带超时时间的等待
                emptyWaitSet.await();
            }
            T t = queue.removeLast();
            fullWaitSet.signal();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    // 带超时时间的获取任务的方法
    public T poll(long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size() <= 0) {
                if (nanos <= 0) {
                    return null;
                }
                // 带超时时间的等待
                nanos = emptyWaitSet.awaitNanos(nanos);
            }
            T t = queue.removeLast();
            fullWaitSet.signal();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    // 带拒绝策略的put方法
    public void tryPut(T task, RejectPolicy<T> rejectPolicy) {
        lock.lock();
        try {
            if (queue.size() == size) { // 任务队列已满时，调用拒绝策略
                rejectPolicy.reject(this, task);
            } else {
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
