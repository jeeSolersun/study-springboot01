package com.codeify.springboot01.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author codeify
 * @since 2023/04/21 01:01
 */
public class RegexpTest {
    public static void main(String[] args) {
        String regexp = "\\p{Upper}";
        String input = "Code";
        Matcher matcher = Pattern.compile(regexp).matcher(input);
        System.out.println("matcher.find() = " + matcher.find());
        System.out.println("matcher.group() = " + matcher.group());
    }

    private static void test01() {
        String input = "123codeify123";
        String regexp = "(?<=123)(codeify)(?=123)";
        Pattern compile = Pattern.compile(regexp);
        Matcher matcher = compile.matcher(input);
        System.out.println("matcher.find() = " + matcher.find());
        System.out.println("matcher.group(1) = " + matcher.group(1));
        System.out.println("matcher.group(2) = " + matcher.group(2));
    }
}
