package com.codeify.springboot01.exercise.leetcode.prefix_sum;

import java.util.HashMap;

/**
 * 974. 和可被 K 整除的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 * <p>
 * 子数组 是数组的 连续 部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,0,-2,-3,1], k = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 示例 2:
 * <p>
 * 输入: nums = [5], k = 9
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 */
class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        int reminder = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int end = 0; end < nums.length; end++) {
            pre += nums[end];
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            reminder = (pre % k + k) % k;
            if (map.containsKey(reminder)) {
                count += map.get(reminder);
            }
            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }
        return count;
    }
}