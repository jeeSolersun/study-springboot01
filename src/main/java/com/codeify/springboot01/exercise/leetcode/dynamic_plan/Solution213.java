package com.codeify.springboot01.exercise.leetcode.dynamic_plan;

/**
 * 213. 打家劫舍 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (len == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        // 偷、不偷最后一件屋子，取两者的最大值
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    private int robRange(int[] nums, int left, int right) {
        int len = right - left + 1;
        int[] dp = new int[len];
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left + 1]);
        for (int i = 2; i < len; i++) {
            // nums[i + left]正确
            dp[i] = Math.max(dp[i - 2] + nums[i + left], dp[i - 1]);
            // nums[i]错误
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int rob = new Solution213().rob(nums);
        System.out.println("rob = " + rob);
    }
}