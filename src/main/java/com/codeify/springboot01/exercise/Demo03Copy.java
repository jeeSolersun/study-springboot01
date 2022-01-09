package com.codeify.springboot01.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author codeify
 * @since 2022/01/07 21:25
 */
public class Demo03Copy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = null;
            while (scanner.hasNext()) {
//                System.out.println("111");
                input = scanner.nextLine();
                Matcher matcher = Pattern.compile("0x").matcher(input);
                String result = matcher.replaceFirst("");
                System.out.println(Integer.valueOf(result, 16));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
