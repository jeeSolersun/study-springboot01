package com.codeify.springboot01.exercise.str;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * 示例1
 * 输入：
 * hello nowcoder
 * 复制
 * 输出：
 * 8
 * 复制
 * 说明：
 * 最后一个单词为nowcoder，长度为8
 * @author codeify
 * @since 2022/06/26 23:17
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        String input = "hello world aa bb";
        Pattern compile = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = compile.matcher(input);
        String lastWord = null;
        while (matcher.find()) {
            lastWord = matcher.group();
//            System.out.println("matcher.group() = " + matcher.group());
        }
        System.out.println(lastWord.length());
    }
}
