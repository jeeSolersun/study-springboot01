package com.codeify.springboot01.exercise.leetcode.prefix_sum;

import java.util.HashMap;
import java.util.Map;

class Solution560 {
    // 方法1
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int start = 0; start < len; start++) {
            int sum = 0;
            // 从右往左进行累加
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}