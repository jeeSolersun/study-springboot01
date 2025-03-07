package com.codeify.springboot01.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * @author codeify
 * @since 2023/09/21 18:27
 */
@Slf4j
public class MyTest {
    public static void main(String[] args) {
        // // 创建一个 ZonedDateTime 实例，使用系统默认时区
        // ZonedDateTime zonedDateTime = ZonedDateTime.now();
        // System.out.println("Original ZonedDateTime: " + zonedDateTime);
        //
        // // 将 ZonedDateTime 转换为 UTC 时区，但保持时间戳不变
        // ZonedDateTime zonedDateTimeInUTC = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        // System.out.println("ZonedDateTime in UTC: " + zonedDateTimeInUTC);
        //
        // // 将 ZonedDateTime 转换为另一个时区，例如 Asia/Shanghai，但保持时间戳不变
        // ZonedDateTime zonedDateTimeInShanghai = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        // System.out.println("ZonedDateTime in Asia/Shanghai: " + zonedDateTimeInShanghai);


        // ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC"));
        // System.out.println("utc = " + utc);
        //
        // ZonedDateTime zonedDateTime = utc.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        // System.out.println("zonedDateTime = " + zonedDateTime);
        String text = "2023-09-21 18:27:01";

        DateTimeFormatter utc = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));

        LocalDateTime parse1 = LocalDateTime.parse(text, utc);
        System.out.println("parse1 = " + parse1);
        DateTime parse2 = DateUtil.parse(text, utc);
        System.out.println("parse2 = " + parse2);
        ZonedDateTime parse = ZonedDateTime.parse(text, utc);
        System.out.println("parse = " + parse);
        // ZonedDateTime zonedDateTime1 = parse.toLocalDateTime().atZone(ZoneId.of("UTC"));
        // System.out.println("zonedDateTime1 = " + zonedDateTime1);
        // ZonedDateTime zonedDateTime2 = zonedDateTime1.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        // System.out.println("zonedDateTime2 = " + zonedDateTime2);

    }

    private static void test07() {
        List<String> list = FileUtil.readLines("/Users/sunhanbing/IdeaProjects/study-springboot01/src/main/resources/static/dianfei.txt", StandardCharsets.UTF_8);
        List<Integer> integerList = list.stream().map(Integer::valueOf)
//                .collect(Collectors.collectingAndThen(Collectors.toList(), intList -> {
//                    intList.sort(Comparator.comparingInt(obj -> (Integer) obj).reversed());
//                    return intList;
//                }));
                .sorted().collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if (i > 0) {
                int remainder = integerList.get(i) - integerList.get(i - 1);
                System.out.println("2023年" + i + "月的电费为：" + remainder + "度");
                resultList.add(remainder);
            }
        }
        IntSummaryStatistics collect = resultList.stream()
                .collect(Collectors.summarizingInt(val -> val));
        System.out.println("collect = " + collect);
    }

    private static void test06() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.println("format = " + format);
        String format1 = now.format(dateTimeFormatter);
        System.out.println("format1 = " + format1);
    }

    private static void test5() {
        try {
            int s = 1 / 0;
        } catch (RuntimeException err) {
            log.info("err: {}", err.getMessage());
        }
    }

    private static void test4() {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
//        Thread t1 = new Thread(() -> {
//            doWrite(writeLock);
//        }, "t1");

        Thread t2 = new Thread(() -> {
            doRead(readLock);
        }, "t2");
        Thread t3 = new Thread(() -> {
            doRead(readLock);
        }, "t3");
//        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void doWrite(ReentrantReadWriteLock.WriteLock writeLock) {
        try {
            log.info("write start...");
            writeLock.lock();
            log.info("write work...");
            TimeUnit.SECONDS.sleep(2);
            log.info("write stop...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    private static void doRead(ReentrantReadWriteLock.ReadLock readLock) {
        try {
            log.info("read start...");
            readLock.lock();
            log.info("read work...");
            TimeUnit.SECONDS.sleep(1);
            log.info("read stop...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    private static void test3() {
        for (int i = -10; i < 10; i++) {
            test2(i);
        }
    }

    private static void test2(int num) {
        int i = num % 3;
        int i1 = (num % 3 + 3) % 3;
        System.out.printf("num = %s, %s, %s i1-i = %s\n", num, i, i1, i1 - i);
    }

    private static void test01() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.compute(2, (key, value) -> value != null ? value + 1 : 0 + 1);
        System.out.println("map = " + map);
    }
}
