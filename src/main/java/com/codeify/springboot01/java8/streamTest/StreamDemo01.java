package com.codeify.springboot01.java8.streamTest;

import com.codeify.springboot01.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by sunhanbing on 2021/06/20 19:17
 */
public class StreamDemo01 {
    private static final List<Apple> appStore  = new ArrayList();
    static {
        appStore.add(new Apple(1, "a1", "red", 100));
        appStore.add(new Apple(2, "a2", "red", 200));
        appStore.add(new Apple(3, "a3", "green", 300));
        appStore.add(new Apple(4, "a4", "green", 400));
        appStore.add(new Apple(5, "a5", "green", 500));
    }

    public static void main(String[] args) {
//        doFormat(() -> System.out.println(String.format("hello %s", "lambda")));
//        doFormat(StreamDemo::format2);
//        doFormat(new StreamDemo() :: format3);
        /*Map<String, Integer> s = appStore.stream().filter(a -> a.getColor().equals("green"))
                .collect(Collectors.toMap(a -> a.getColor(), a -> a.getWeight(), (a, b) -> {
                    System.out.println(String.format("%s, %s", a, b));
                    return a + b;
                }));
        System.out.println(s);*/
        String[] s = (String[])appStore.stream().filter(a -> a.getId() >= 2)
                .map(a -> a.getColor())
                .toArray();
        System.out.println(s);
        System.out.println(Arrays.asList(s).toString());
        // 分组统计
       /* Map<String, Integer> s = appStore.stream()
                .collect(Collectors.groupingBy((a) -> a.getColor(), Collectors.summingInt(a -> a.getWeight())));
        System.out.println(s);*/
    }

    public void format3(){
        System.out.println("format3()...");
    }

    public static void format2(){
        System.out.println("format2()...");
    }
    public static void doFormat(Format f){
        f.format();
    }

    public interface Format {
        void format();
    }
}
