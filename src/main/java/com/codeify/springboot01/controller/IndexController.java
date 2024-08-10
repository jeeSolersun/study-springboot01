package com.codeify.springboot01.controller;

import com.codeify.springboot01.entity.Apple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * created by sunhanbing on 2021/04/18 19:31
 */
@Slf4j
@Controller
@RequestMapping("index")
public class IndexController {
    /*private final ConcurrentHashMap<String, ReentrantLock> map = new ConcurrentHashMap<>();

    private ReentrantLock getLockByTaskCode(String taskCode) {
        return map.computeIfAbsent(taskCode, key -> new ReentrantLock());
    }

    @RequestMapping("/commit/{taskCode}")
    @ResponseBody
    public String commit(@PathVariable String taskCode) {
        ReentrantLock lock = getLockByTaskCode(taskCode);
        try {
            lock.lock();
            log.info("commit invoked, and taskCode: {}", taskCode);
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("lock.getQueueLength() = {}", lock.getQueueLength());
            if (lock.getQueueLength() == 0) {
                map.remove(taskCode);
            }
            lock.unlock();
        }
        return "commit success";
    }*/

    @RequestMapping(value = "/hello")
    @ResponseBody
    public Apple hello() {
        Apple apple = new Apple(1, "aa", "red", 22);
        // sleep();
        return apple;
//        return "hello, spring-security";
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
