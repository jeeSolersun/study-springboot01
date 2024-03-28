package com.codeify.springboot01.java8.streamTest;

import com.codeify.springboot01.entity.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * created by sunhanbing on 2021/08/04 23:51
 */
public class StreamDemo02 {
    private static final List<Apple> appStore  = new ArrayList();
    static {
        appStore.add(new Apple(1, "a1", "red", 100));
        appStore.add(new Apple(2, "a2", "red", 200));
        appStore.add(new Apple(3, "a3", "green", 300));
        appStore.add(new Apple(4, "a4", "green", 400));
        appStore.add(new Apple(5, "a5", "green", 500));
    }
    public static void main(String[] args) {
//        appStore.stream().collect();
        System.out.print("aaa");
        System.out.println();
        System.out.println("bbb");
    }
}
