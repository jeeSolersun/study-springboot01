package com.codeify.springboot01.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * @author codeify
 * @since 2022/01/07 21:09
 */
public class Demo02 {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String num = bufferedReader.readLine();
            int nn = Integer.parseInt(num);
            String[] strings = new String[nn];
            for (int i = 0; i < nn; i++) {
                strings[i] = bufferedReader.readLine();
            }
//            Arrays.sort(strings);
            Arrays.stream(strings).sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
