package com.codeify.springboot01.java8.streamTest;

import com.codeify.springboot01.entity.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codeify
 * @since 2022/07/29 00:05
 */
public class MyTest22 {
    private static List<Apple> appStore = new ArrayList<>();

    static {
        appStore.add(new Apple(1, "aa,aa,aaa", "red", 100));
        appStore.add(new Apple(1, "bb,bbb", "red", 200));
        appStore.add(new Apple(2, "cc,dd,ccc", "green", 300));
        appStore.add(new Apple(2, "dd,ddd", "green", 400));
//        appStore.add(new Apple(5, "a5", "green", 500));
    }
    public static void main(String[] args) {
        /*Apple apple = new Apple(1, "aa", "red", 1);
        Apple apple2 = apple.toBuilder().build();
        apple2.setId(2);
        apple2.setName("bb,cc");
        List<String> collect = Stream.of(apple, apple2)
                .map(item -> Arrays.asList(item.getName().split(",")))
                .flatMap(item -> item.stream().filter(Objects::nonNull))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);*/
        // 分组聚合
        /*Map<Integer, Optional<LinkedList>> collect = appStore.stream().collect(Collectors.groupingBy(Apple::getId,
                Collectors.mapping(item -> new LinkedList(Arrays.asList(item.getName().split(","))),
                        Collectors.reducing((res, item) -> {
                            res.addAll(item);
                            return res;
                        }))));
        System.out.println("collect = " + collect);
        // 分组聚合属性值，并且去重，方法1
        Map<Integer, Optional<HashSet<String>>> collect2 = appStore.stream().collect(Collectors.groupingBy(Apple::getId,
                Collectors.mapping((Apple item) -> new HashSet<String>(Arrays.asList(item.getName().split(","))),
                        Collectors.reducing((HashSet<String> res, HashSet<String> item) -> {
                            res.addAll(item);
                            return res;
                        }))));
        System.out.println("collect2 = " + collect2);

        // 分组聚合属性值，并且去重，方法2
        Map<Integer, Optional<LinkedList<String>>> collect3 = appStore.stream().collect(Collectors.groupingBy(Apple::getId,
                Collectors.mapping(item -> new LinkedList<String>(Arrays.asList(item.getName().split(","))),
                        Collectors.reducing((LinkedList<String> res, LinkedList<String> item) -> {
                            res.addAll(item);
//                            res = res.stream().distinct().collect(Collectors.toCollection(LinkedList::new));
                            res = res.stream().filter(str -> str.length() == 2).distinct().sorted(Comparator.comparing(item2 -> item2)).collect(Collectors.toCollection(LinkedList::new));
                            return res;
                        }))));
        System.out.println("collect3 = " + collect3);*/

        /*Map<Boolean, List<Apple>> collect = appStore.stream().collect(Collectors.partitioningBy(item -> item.getId() == 1));
        System.out.println("collect = " + collect);
        Map<Integer, String> collect1 = appStore.stream()
                .collect(Collectors.toMap(Apple::getId, Apple::getName)); // IllegalStateException, toConcurrentMap一样会抛出异常
        System.out.println("collect1 = " + collect1);*/
    }
}
