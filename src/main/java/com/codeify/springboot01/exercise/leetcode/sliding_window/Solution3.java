package com.codeify.springboot01.exercise.leetcode.sliding_window;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        int right = 0;
        // i作为左边界
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                // 从set中移除前一个字符
                set.remove(s.charAt(i - 1));
            }
            while (right < len && !set.contains(s.charAt(right))) {
                // 右指针不断移动，添加新的字符
                set.add(s.charAt(right));
                right++;
            }
            maxLen = Math.max(maxLen, right - 1 - i + 1);
        }
        return maxLen;
    }
}