package com.codeify.springboot01.exercise.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author codeify
 * @since 2022/07/29 01:05
 */
public class Demo07 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Pattern compile = Pattern.compile(".{1,3}");
            String input = bufferedReader.readLine();
            System.out.println("input = " + input);
            Matcher matcher = compile.matcher(input);
            while (matcher.find()) {
                String group = matcher.group();
                if (group.length() < 3) {
                    StringBuilder stringBuilder = new StringBuilder(group);
                    int n = 3 - group.length();
                    while (n-- != 0) {
                        stringBuilder.append("0");
                    }
                    group = stringBuilder.toString();
                }
                System.out.println(group);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
