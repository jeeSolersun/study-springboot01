package com.codeify.springboot01.exercise.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
class Solution438 {
    // 方法一超出时间限制
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        List<Character> cList = new ArrayList<>();
        int right = 0;
        for (int i = 0; i < sLen; i++) {
            if (i != 0) {
                cList.remove((Character) s.charAt(i - 1));
            }
            while ((right - i + 1) <= pLen && right < sLen) {
                cList.add(s.charAt(right));
                right++;
            }

            // TODO
            /*Collections.sort(cList);
            Character[] characters = cList.toArray(new Character[0]);
            String collect = Arrays.stream(characters).map(String::valueOf).collect(Collectors.joining());

            char[] chars2 = p.toCharArray();
            Arrays.sort(chars2);
            String s2 = String.valueOf(chars2);
            if (collect.equals(s2)) {
                list.add(i);
            }*/

            String collect = cList.stream().sorted().map(val -> String.valueOf(val)).collect(Collectors.joining());
            char[] chars1 = collect.toCharArray();
            char[] chars2 = p.toCharArray();
            Arrays.sort(chars2);
            if (Arrays.equals(chars1, chars2)) {
                list.add(i);
            }

        }
        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        int right = 0;
        for (int i = 0; i < sLen; i++) {
            if (i != 0) {
                sCount[s.charAt(i - 1) - 'a']--;
            }
            while (right < sLen && (right - i + 1) <= pLen) {
                sCount[s.charAt(right) - 'a']++;
                right++;
            }
            if (Arrays.equals(pCount, sCount)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = new Solution438().findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }
}