package com.codeify.springboot01.exercise.aa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 输入：
 *  0xA
 *  0xAA
 *  输出：
 *  10
 *  170
 * @author codeify
 * @since 2022/01/07 21:25
 */
public class Demo03 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = null;
            while ((input = br.readLine()) != "") {
                System.out.println("111");
                Matcher matcher = Pattern.compile("0x").matcher(input);
                String result = matcher.replaceFirst("");
                System.out.println(Integer.valueOf(result, 16));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
