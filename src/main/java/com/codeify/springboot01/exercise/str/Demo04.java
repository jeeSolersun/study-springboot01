package com.codeify.springboot01.exercise.str;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

/**
 * 描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 * <p>
 * 输出描述：
 * 输出该字符串反转后的字符串。
 * <p>
 * 示例1
 * 输入：
 * abcd
 * 复制
 * 输出：
 * dcba
 * 复制
 *
 * @author codeify
 * @since 2022/06/27 00:52
 */
public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
//        method01(next);
        method02(next);
    }

    // 方法2、不需要额外的空间，双指针
    private static void method02(String next) {
        char[] chars = next.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        for (int i = 0; i < chars.length && left < right; i++) {
            System.out.println(left + "," + right);
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left = i + 1;
            right = chars.length - 1 - left;
        }
        System.out.println(new String(chars));
    }

    // 方法1、需要额外的空间
    private static void method01(String next) {
        String[] split = next.split("");
        String[] strings = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            int currIndex = split.length - 1 - i;
            strings[currIndex] = split[i];
        }
        Optional<String> reduce = Arrays.stream(strings)
                .reduce((result, element) -> result = result.concat(element));
//        String join = String.join("", strings);
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.reverse() //
        System.out.println(reduce.orElse(""));
    }
}
