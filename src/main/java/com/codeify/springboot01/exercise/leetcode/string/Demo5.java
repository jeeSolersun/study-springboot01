package com.codeify.springboot01.exercise.leetcode.string;

import java.util.Scanner;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author codeify
 * @since 2023/02/14 00:50
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            String res = longestPalindrome(next);
            System.out.println("res = " + res);
        }
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            // aba这种回文字符串的最大长度
            int len1 = getMaxLenOfStr(s, i, i);
            // bb这种回文字符串的最大长度
            int len2 = getMaxLenOfStr(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int getMaxLenOfStr(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
