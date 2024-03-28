package com.codeify.springboot01.exercise;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author codeify
 * @since 2022/01/10 01:08
 */
public class MyTest {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 3; i++) {
            inner: for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    break outer;
//                    break inner;
                }
                System.out.println(i + ", " + j);
            }
        }
    }

    private static void test11() {
        // String.valueOf()方法
        // char[] 转换成Character[]
        char[] chars = {'c', 'o'};
        Character[] characters = String.valueOf(chars).chars().mapToObj(val -> (char) val)
                .toArray(Character[]::new);
//                .collect(Collectors.toList());
        // Character[]转换成char[]
        String collect = Arrays.stream(characters).map(val -> String.valueOf(val)).collect(Collectors.joining());
        char[] chars1 = collect.toCharArray();
    }

    private static void test10() {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println("map = " + map);
    }

    private static void test09() {
        List<Integer> collect = Arrays.stream(new int[]{1}).boxed().collect(Collectors.toList());
        System.out.println("collect = " + collect);

        // 利用stream
        // Character[]转成char[]
        Character[] c1 = new Character[]{'j', 'a'};
        String collect1 = Arrays.stream(c1).map(val -> String.valueOf(val)).collect(Collectors.joining());
        char[] chars = collect1.toCharArray();
        System.out.println("chars = " + Arrays.toString(chars));

        // char[]转换成Character[]
        char[] c2 = new char[]{'g', 'o'};
        Character[] characters = String.valueOf(c2).chars().mapToObj(val -> (char) val).toArray(Character[]::new);
        System.out.println("characters = " + Arrays.toString(characters));
    }

    private static void test08() {
        Integer i1 = null;
        int i2 = (Integer) i1;
    }

    public static int test22() {
        int i = 0;
        try {
            ++i;
        } finally {
            ++i;
        }
        return ++i;
    }

    public void test07() {
        //        int i = test22();
//        System.out.println("i = " + i);
//        String s = "aa";
//        s.replaceAll("$", "#")
    }

    private static void test06() {
        int a = 128;
        Integer b = 128;
        Integer c = 128;
        System.out.println("a==b = " + (a == b));
        System.out.println("a==b = " + (b == c));
    }


//    public void test22() {
//
//    }
//    public String test22(String a) {
//        return null;
//    }

    private static void test05() {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = map.computeIfAbsent("name", val -> {
            return new ArrayList(Arrays.asList("aa"));
        });
        list.add("bb");
        System.out.println("list = " + list);
    }

    private static void test04() {
        // 基本类型可以通过stream流来进行转换
        int[] arr = {1, 2, 3};
        Arrays.stream(arr).boxed().forEach(ele -> {
            System.out.println("ele.getClass() = " + ele.getClass());
        });
        char[] chars = "hello".toCharArray();
        String str = new String(chars);
//        System.out.println("str = " + str);
        List<Character> collect = str.chars().mapToObj(val -> (char) val).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        // 包装类型可以直接转换成List
        Integer[] integers = {1, 2, 3};
        List<Integer> integers1 = Arrays.asList(integers);
        System.out.println("integers1 = " + integers1);
    }

    private static void test03() {
        List<Character> list1 = Arrays.asList('e', 'a', 't');
        List<Character> list2 = Arrays.asList('t', 'e', 'a');
        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));

        char[] chars1 = "eat".toCharArray();
        char[] chars2 = "tea".toCharArray();
//        System.out.println("Arrays.equals(chars1, chars2) = " + Arrays.equals(chars1, chars2)); // false
//        System.out.println("Arrays.binarySearch(chars1, 'a') = " + Arrays.binarySearch(chars1, 'a')); // 1
    }

    private static void test02() {
        int[] ints = new int[3];
        Arrays.fill(ints, 2);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    private static void test01() {
        System.out.println(Integer.parseInt("-1"));
        System.out.println((int) (Math.random() * 10) + 1);
        System.out.println((int) (Math.random() * 10) + 1);
        System.out.println((int) (Math.random() * 10) + 1);
        System.out.println((int) (Math.random() * 10) + 1);
    }
}
