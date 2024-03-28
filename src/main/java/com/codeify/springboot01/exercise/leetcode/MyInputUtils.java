package com.codeify.springboot01.exercise.leetcode;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author codeify
 * @since 2023/02/05 18:40
 */
public class MyInputUtils {
    public static void cyclicInputArr(Function<Integer[], Integer> fn) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
//            long[] arr = Stream.of(input.split(",")).mapToLong(Integer::parseInt).toArray();
            Integer[] arr = (Integer[]) Stream.of(input.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            fn.apply(arr);
        }
    }

    public static <E> void cyclicInputArr1(Function<E[], E> fn) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            E[] arr = (E[]) Stream.of(input.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            fn.apply(arr);
        }
    }

}
