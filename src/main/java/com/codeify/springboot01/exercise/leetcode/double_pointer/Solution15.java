package com.codeify.springboot01.exercise.leetcode.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
class Solution15 {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = len - 1;
            for (int second = first + 1; second < len; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while(second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return res;
    }

    // 超出时间限制
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = len - 1;
//            for2:
            for (int second = first + 1; second < len; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                for (third = len - 1; third > second; third--) {
                    if (third < len - 1 && nums[third] == nums[third + 1]) {
                        continue;
                    }
//                    // 如果指针重合，随着 b 后续的增加
//                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
//                    if (second == third) {
//                        break for2;
//                    }
                    if (nums[second] + nums[third] == target) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
//        List<List<Integer>> lists = new Solution15().threeSum(nums);
//        System.out.println("lists = " + lists);
        List<List<Integer>> lists2 = new Solution15().threeSum1(nums);
        System.out.println("lists2 = " + lists2);
    }
}