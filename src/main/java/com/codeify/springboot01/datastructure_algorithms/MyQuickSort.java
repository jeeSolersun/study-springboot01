package com.codeify.springboot01.datastructure_algorithms;

import java.util.Arrays;

/**
 * 快速排序：分区加递归经典算法
 *
 * @author codeify
 * @since 2022/06/23 23:06
 */
public class MyQuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 8, 5, 3, 9, 7, 6};
//        int[] arr = {2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    // 快速排序
    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = portion(arr, leftBound, rightBound);
        sort(arr, leftBound, mid - 1);
        sort(arr, mid + 1, rightBound);
    }

    // 分区并找到轴
    private static int portion(int[] arr, int leftBound, int rightBound) {
        // 左、右指针
        int left = leftBound;
        int right = rightBound - 1;
        // 以右边元素为轴
        int pivot = arr[rightBound];
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if (left < right) {
                // 左指针与右指针值交换
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        // 左指针与轴交换
        arr[rightBound] = arr[left];
        arr[left] = pivot;
        return left;
    }

}
