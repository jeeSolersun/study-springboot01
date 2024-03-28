package com.codeify.springboot01.java8.streamTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author codeify
 * @since 2022/09/07 01:33
 */
@Slf4j
public class StreamDemo04 {
    public static void main(String[] args) {
        List<String> list = Collections.nCopies((int)Math.pow(10, 7), "a");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("distinct on sequence");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        stopWatch.stop();
        log.info("collect = {}, spend time = {}", collect, stopWatch.getLastTaskTimeMillis());
        log.info(String.join("", Collections.nCopies(22, "-")));

        stopWatch.start("distinct on parallel");
        List<String> collect1 = list.parallelStream().distinct().collect(Collectors.toList());
        stopWatch.stop();
        log.info("collect = {}, spend time = {}", collect1, stopWatch.getLastTaskTimeMillis());
        System.out.println("stopWatch.prettyPrint() = " + stopWatch.prettyPrint());
    }
}
