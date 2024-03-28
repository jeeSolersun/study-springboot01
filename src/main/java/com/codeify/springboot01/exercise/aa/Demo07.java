package com.codeify.springboot01.exercise.aa;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 *
 * 数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10
 * 9
 *  +14
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * 示例1
 * 输入：
 * 180
 * 复制
 * 输出：
 * 2 2 3 3 5
 * @author codeify
 * @since 2022/08/04 20:20
 */
public class Demo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        /*int size = Integer.parseInt(next);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            String num = scanner.next();
            arr[i] = Integer.parseInt(num);
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));*/

        int num = Integer.parseInt(next);
        while (num != 1) {
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                    break;
                }
            }
        }

    }
}
