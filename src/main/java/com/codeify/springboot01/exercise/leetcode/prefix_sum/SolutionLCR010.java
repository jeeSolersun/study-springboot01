package com.codeify.springboot01.exercise.leetcode.prefix_sum;

/**
 * LCR 010. 和为 K 的子数组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2：
 *
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
class SolutionLCR010 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for(int right=left; right >= 0; right--) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}