package com.codeify.springboot01.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最大子矩阵
 *
 * @author codeify
 * @since 2022/01/09 23:44
 */
public class Demo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mAndN = scanner.nextLine();
        String[] s = mAndN.split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
//        System.out.println(String.format("%s, %s", m, n));
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String oneLine = scanner.nextLine();
            String[] oneLineArr = oneLine.split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(oneLineArr[j]);
            }
        }
//        System.out.println(Arrays.toString(matrix));
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int max = calcMaxMatrix(matrix);
        System.out.println("max = " + max);
    }

    public static int calcMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        int o;
        int p;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                o = i;
                p = j;
                int sum = 0;
                for (int k = o; k < m; k++) {
                    for (int l = p; l < n; l++) {
                        sum += matrix[k][l];
                    }
                    System.out.println("sum = " + sum);
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }
}
