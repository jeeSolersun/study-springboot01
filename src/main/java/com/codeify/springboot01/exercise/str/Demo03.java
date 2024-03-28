package com.codeify.springboot01.exercise.str;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * abc00000
 * @author codeify
 * @since 2022/06/26 23:30
 */
public class Demo03 {
    public static void main(String[] args) {
//        int[][] a = new int[2][2];
//        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        int[] ints = new int[2];
//        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.length() == 0) {
            return;
        } else {
            Pattern compile = Pattern.compile(".{8}|.{1,8}");
            Matcher matcher = compile.matcher(input);
            while (matcher.find()) {
                String group = matcher.group();
                if (matcher.group().length() < 8) {
                    for (int i = 0; i < 8 - matcher.group().length(); i++) {
                        group = group.concat("0");
                    }
                    System.out.println(group);
                } else {
                    System.out.println(matcher.group());
                }
            }
        }
    }
}
