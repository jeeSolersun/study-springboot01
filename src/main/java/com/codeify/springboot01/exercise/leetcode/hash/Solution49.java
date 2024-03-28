package com.codeify.springboot01.exercise.leetcode.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
class Solution49 {
    // 方法1
    public List<List<String>> groupAnagrams1(String[] strs) {
        // 使用stream进行分组
        Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(val -> {
            char[] chars = val.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));
        return new ArrayList<>(map.values());
    }

    // 方法2
    public List<List<String>> groupAnagrams(String[] strs) {
        // 分组map
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.computeIfAbsent(key, val -> {
                return new ArrayList<String>();
            });
            strings.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> res = new Solution49().groupAnagrams1(strs);
        List<List<String>> res = new Solution49().groupAnagrams(strs);
        System.out.println("res = " + res);
    }
}