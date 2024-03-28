package com.codeify.springboot01.exercise.leetcode.double_pointer;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 */
class Solution283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int pt1 = 0;
        int pt2 = 0;
        while (pt1 < len) {
            if (nums[pt1] != 0) {
                int temp = nums[pt1];
                nums[pt1] = nums[pt2];
                nums[pt2] = temp;
                pt2++;
            }
            pt1++;
        }
    }
}