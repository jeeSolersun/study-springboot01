package com.codeify.springboot01.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author codeify
 * @since 2021/09/14 23:11
 */
public class Demo01 {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("\\d");
//        String pattern = compile.pattern();
        Matcher matcher = compile.matcher("22");
//        System.out.println(matcher.group(0));
//        String s1 = "abc22";
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.find());
    }
}
