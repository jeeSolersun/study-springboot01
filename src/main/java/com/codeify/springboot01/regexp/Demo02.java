package com.codeify.springboot01.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author codeify
 * @since 2022/01/04 22:46
 */
public class Demo02 {
    public static void main(String[] args) {
        // 1、Patter.matches方法
        /*boolean matches = Pattern.matches(".*codeify.*", "my name is codeify");
        System.out.println("matches = " + matches);*/
        // 2、group
        /*String str1 = "This order was placed for QT3000! OK?";
        String pattern = "(\\D+)(\\d+)(.*)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(str1);
        System.out.println(matcher.groupCount());
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }*/
        // 3、
//        String str1 = "codeify and codeify or codeify";
        /*String str1 = "codeify and";
        String pattern = "codeify";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(str1);
        System.out.println("matcher.matches() = " + matcher.matches());
        System.out.println("matcher.lookingAt() = " + matcher.lookingAt());
        System.out.println("matcher.find(0) = " + matcher.find(0));
        System.out.println("matcher.find(0) = " + matcher.find(0));
        System.out.println("matcher.find(0) = " + matcher.find(0));
        System.out.println("matcher.find(1) = " + matcher.find(1));
        System.out.println("matcher.find(1) = " + matcher.find(1));
        System.out.println("matcher.find(1) = " + matcher.find(1));
        System.out.println("matcher.find(1) = " + matcher.find(1));*/
        // 4、
        String pattern = "(hello)";
        Matcher matcher = Pattern.compile(pattern).matcher("hello codeify");
        boolean b = matcher.find();
//        boolean matches = matcher.matches();
//        boolean b = matcher.lookingAt();
        int start = matcher.start();
        int end = matcher.end();
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println(matcher.group(0));
        System.out.println(matcher.group(1));
        System.out.println(matcher.groupCount());
    }
}
