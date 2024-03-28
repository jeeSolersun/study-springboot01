package com.codeify.springboot01.exercise.leetcode.double_pointer;

/**
 * 11. 盛最多水的容器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
class Solution11 {
    public int maxArea(int[] height) {
        int len = height.length;
        // 双指针
        int left = 0;
        int right = len - 1;
        int maxArea = 0;
        int width = 0;
        while ((width = right - left) > 0) {
            int min = 0;
            if (height[left] <= height[right]) {
                min = height[left];
                left++;
            } else {
                min = height[right];
                right--;
            }
            // 最小的高度*宽度为当前所盛最多的水
            maxArea = Math.max(maxArea, min * width);
        }
        return maxArea;
    }
}