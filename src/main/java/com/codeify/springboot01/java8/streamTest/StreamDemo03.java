package com.codeify.springboot01.java8.streamTest;

import com.codeify.springboot01.entity.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * created by sunhanbing on 2021/08/07 22:00
 */
public class StreamDemo03 {
    private static List<Apple> appStore = new ArrayList<>();

    static {
        appStore.add(new Apple(1, "aa,aa,aaa", "red", 100));
        appStore.add(new Apple(1, "bb,bbb", "red", 200));
        appStore.add(new Apple(2, "cc,ccc", "green", 300));
        appStore.add(new Apple(2, "dd,ddd", "green", 400));
//        appStore.add(new Apple(5, "a5", "green", 500));
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

    }
}
