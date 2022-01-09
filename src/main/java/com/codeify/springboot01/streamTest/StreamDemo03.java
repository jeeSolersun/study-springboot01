package com.codeify.springboot01.streamTest;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * created by sunhanbing on 2021/08/07 22:00
 */
public class StreamDemo03 {
    private static List<Apple> appStore = new ArrayList<>();

    static {
        appStore.add(new Apple(1, "a1", "red", 100));
        appStore.add(new Apple(2, "a2", "red", 200));
        appStore.add(new Apple(3, "a3", "green", 300));
        appStore.add(new Apple(4, "a4", "green", 400));
        appStore.add(new Apple(5, "a5", "green", 500));
    }

    public static void main(String[] args) {
//        new Object();
//        new HashMap<>().put(11, 22);
//        String s1 = null;
//        String s2 = s1;
//        s1 = new String("22");
//        System.out.println(s2);
       /* Optional<Apple> reduce = appStore.stream().reduce((a, b) -> {
            return new Apple(22, "hello", "hello", a.getWeight() + b.getWeight());
        });*/
//        Optional<Integer> reduce = appStore.stream().map(Apple::getWeight).reduce(Integer::sum);
//        System.out.println(reduce.get());
        /*List<Integer> l1 = Arrays.asList(1, 2, 3);
        StringBuilder collect = l1.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect.toString());*/
//        System.out.println(Math.addExact(1, 2));
        List<Integer> collect = Stream.of(1, 5, 3).sorted(Comparator.comparingInt(item -> item))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
