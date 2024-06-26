package com.codeify.springboot01.exercise.aa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 *
 * 数据范围： n >= 1 && n <= 500
 * @author codeify
 * @since 2022/01/04 23:45
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();

            String[] split = str.split("");
            long count = Arrays.stream(split)
                    .filter(item -> {
                        char a = (char) item.toCharArray()[0];
                        return a >= 0 && a <= 127;
                    })
                    .distinct()
                    .count();
            System.out.println(count);
        }
    }
}
