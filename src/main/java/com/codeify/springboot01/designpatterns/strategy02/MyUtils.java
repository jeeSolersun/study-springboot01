package com.codeify.springboot01.designpatterns.strategy02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author codeify
 * @since 2021/08/30 00:14
 */
public class MyUtils {

    /**
     * 1、利用自身比较（Comparable）实现的排序方法
     *
     * @param targetArr
     * @param <T>
     */
    public static <T extends Comparable> void sort(T[] targetArr) {
        for (int i = 0; i < targetArr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < targetArr.length; j++) {
                minIndex = targetArr[i].compareTo(targetArr[j]) == -1 ? i : j;
            }
            T tmp = targetArr[i];
            targetArr[i] = targetArr[minIndex];
            targetArr[minIndex] = tmp;
        }
    }

    /**
     * 2、使用策略模式实现的排序方法（传入Comparator对象实例）
     * 更加灵活和强大
     *
     * @param targetArr
     * @param comparator
     * @param <T>
     */
    public static <T> void sort(T[] targetArr, Comparator<T> comparator) {
        for (int i = 0; i < targetArr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < targetArr.length; j++) {
                minIndex = comparator.compare(targetArr[i], targetArr[j]) < 0 ? i : j;
            }
            T tmp = targetArr[i];
            targetArr[i] = targetArr[minIndex];
            targetArr[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        /*Integer[] arr = {1, 5, 3, 7, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));*/
        // 1、对Integer数组进行排序
        Integer[] arr = {1, 5, 3, 7, 2};
        sort(arr, (a, b) -> a - b);
        System.out.println(Arrays.toString(arr));
//        System.out.println(String.format("%0100d", 2));
//        System.out.println(new String(new char[100]).replace("\0", "a"));
//        System.out.println(String.join("", Collections.nCopies(20, "-")));
        // 2、对String数组进行排序
        String[] arr2 = {"abc", "a", "cbc", "b"};
        sort(arr2, (a, b) -> a.compareTo(b));
        System.out.println(Arrays.toString(arr2));
        // 3、对自定义对象进行自定义排序
        Cat c1 = new Cat(1, "a", 2);
        Cat c2 = new Cat(3, "b", 5);
        Cat c3 = new Cat(2, "c", 3);
        Cat[] cats = {c1, c2, c3};
        sort(cats, (a, b) -> a.getId() - b.getId()); // [Cat{id=1, name='a', age=2}, Cat{id=2, name='c', age=3}, Cat{id=3, name='b', age=5}]
        sort(cats, (a, b) -> a.getAge() - b.getAge()); // [Cat{id=1, name='a', age=2}, Cat{id=2, name='c', age=3}, Cat{id=3, name='b', age=5}]
        System.out.println(Arrays.toString(cats));
    }
}
