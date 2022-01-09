package com.codeify.springboot01.threadAndExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author codeify
 * @since 2021/09/19 00:50
 */
public class Demo01 {
    public static void main(String[] args) {
        /*Person p = new Person();
        p.setId("22");
        p.getId();
        System.out.println("p.toString() = " + p.toString());
        System.out.println("p.hashCode() = " + p.hashCode());
        System.out.println("p.equals(new Person()) = " + p.equals(new Person()));*/
        AtomicInteger atomicInteger = new AtomicInteger(0);

        IntStream.range(1, 10).parallel()
                .forEach(item -> {
                    atomicInteger.incrementAndGet();
                });
        System.out.println("atomicInteger.get() = " + atomicInteger.get());
    }
}
