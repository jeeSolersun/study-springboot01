package com.codeify.springboot01.exercise.str;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：
 * aabcddd
 * 复制
 * 输出：
 * aaddd
 * @author codeify
 * @since 2022/06/28 20:31
 */
public class Demo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] chars = next.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : map.values()) {
            if (integer < min) {
                min = integer;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char item : chars) {
            if (!map.get(item).equals(min)) {
                stringBuilder.append(item);
            }
        }
        System.out.println(stringBuilder.toString());
//        map.values()
    }
}
