package com.codeify.springboot01.threadAndExecutor.chapter8;

import lombok.extern.slf4j.Slf4j;

/**
 * @author codeify
 * @since 2022/03/29 23:18
 */
@Slf4j
public class MyTest01 {
    public static void main(String[] args) {
      /*  String format = String.format("%(3d", 2);
        System.out.println("format = " + format);
        List<String> a = Collections.nCopies(10, "a");*/
//        a.forEach(item -> System.out.println("item = " + item));

        /*Iterator<String> iterator = a.iterator();
        System.out.println("iterator = " + iterator);*/

        /*System.out.println("a = " + a.toString());
        String join = String.join("-", a);
        System.out.println("join = " + join);

        Arrays.asList("a", "b", "c")
                .stream().parallel()
                .forEach(item -> {

                    log.debug("item = {}", item);
                });
        log.debug("stop...");*/
//        int maxPrime = getMaxPrime(100);
//        System.out.println("maxPrime = " + maxPrime);
//
//        System.out.println("Math.sqrt(4) = " + Math.sqrt(4));
//        System.out.println("Math.sqrt(9) = " + Math.sqrt(9));


    }

    // 求一个数中最大的素数
    public static int getMaxPrime(int n) {
        int max = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                max = i;
            }
        }
        return max;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    /*
    // 打印99乘法表
    public static void print99MultiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // 找出一个字符串中最多重复字符
    public static String findMaxRepeatChar(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        int max = 0;
        char maxChar = ' ';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                maxChar = (char) i;
            }
        }
        return String.valueOf(maxChar);
    }*/


}