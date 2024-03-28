package com.codeify.springboot01.exercise.leetcode.dynamic_plan;

/**
 * 70. 爬楼梯
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 */
class Solution70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] solutions = new int[n + 1];
        solutions[1] = 1;
        solutions[2] = 2;
        for (int i = 3; i <=n ; i++) {
            solutions[i] = solutions[i - 2] + solutions[i-1]; // 状态转移方程
        }
        return solutions[n];
    }
}