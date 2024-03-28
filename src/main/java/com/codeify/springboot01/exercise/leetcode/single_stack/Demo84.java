package com.codeify.springboot01.exercise.leetcode.single_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84.柱状图中最大的矩形
 *
 * @author codeify
 * @since 2023/02/02 23:15
 */
public class Demo84 {
    public static void main(String[] args) {
//        int[] arr = {2,1,5,6,2,3};
        int[] arr = {2,4};
//        int len = arr.length;
//        int[] arr2 = new int[len + 2];
//        System.arraycopy(arr, 0, arr2, 1, len);
//        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
//        getLargestArea(arr);
        System.out.println("getLargestArea(arr) = " + getLargestArea(arr));
    }

    public int largestRectangleArea(int[] ints) {
        int len = ints.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return ints[0];
        }
        int area = 0;
        int[] newArray = new int[len + 2];
        System.arraycopy(ints, 0, newArray, 1, len);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len + 2; i++) {
            while (!stack.isEmpty() && newArray[i] < newArray[stack.peekLast()]) {
                int height = newArray[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        return area;
    }

    /**
     * 暴力解法+哨兵
     *
     * @param arr 输入
     * @return 结果
     */
    private static int getLargestArea(int[] arr) {
        int area = 0;
        int len = arr.length;
        int[] arr2 = new int[len + 2];
        System.arraycopy(arr, 0, arr2, 1, len);
        int newLen = arr2.length;
        for (int i = 1; i < newLen - 1; i++) {
            int height = arr2[i];
            int j = i, k = i;
            int left = i, right = i;
            while (j-- > 0) {
                if (arr2[j] < height) {
                    left = j;
                    break;
                }
            }
            while (k++ < newLen - 1) {
                if (arr2[k] < height) {
                    right = k;
                    break;
                }
            }
            int width = right - left - 1;
            area = Math.max(area, height * width);
        }
        return area;
    }
}
