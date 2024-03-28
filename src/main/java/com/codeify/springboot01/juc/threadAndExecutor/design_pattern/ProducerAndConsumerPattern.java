package com.codeify.springboot01.juc.threadAndExecutor.design_pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * 生产者消费者模式
 *
 * @author codeify
 * @since 2021/12/29 20:34
 */
@Slf4j
public class ProducerAndConsumerPattern {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue messageQueue = new MessageQueue(2);
        // 多个生产者
        for (int i = 0; i < 3; i++) {
            int ii = i;
            new Thread(() -> {
                messageQueue.putMsg("消息" + ii);
            }).start();
        }
        // 一个消费者
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String msg = messageQueue.getMsg();
                log.debug("获取到的消息：{}", msg);
            }
        }, "t2").start();

    }
}

@Slf4j(topic = "com.codeify.MessageQueue")
class MessageQueue {
    private final LinkedList<String> queue = new LinkedList();

    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public void putMsg(String msg) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("添加消息：{}", msg);
            queue.addLast(msg);
            queue.notifyAll();
        }
    }

    public String getMsg() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String msg = queue.removeFirst();
            queue.notifyAll();
            return msg;
        }
    }
}
