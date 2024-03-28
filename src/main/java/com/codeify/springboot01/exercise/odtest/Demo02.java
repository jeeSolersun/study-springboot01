package com.codeify.springboot01.exercise.odtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OD考试--求矩阵中最大相邻的男生数
 *
 * @author codeify
 * @since 2022/08/04 20:57
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineAndColumm = scanner.next();
        String[] split = lineAndColumm.split(",");
        int line = Integer.parseInt(split[0]);
        int column = Integer.parseInt(split[1]);
        char[][] matrix = new char[line][column];
        for (int i = 0; i < line; i++) {
            String input = scanner.next();
            String[] split1 = input.split(",");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = split1[j].toCharArray()[0];
            }
        }
        // 打印
//        for (int m = 0; m <line; m++) {
//            System.out.println("Arrays.toString(matrix[m]) = " + Arrays.toString(matrix[m]));
//        }
        //
        int maxMans = getMaxMans(matrix);
        System.out.println(maxMans);
    }

    private static int getMaxMans(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
//        System.out.println("row = " + row);
//        System.out.println("col = " + col);
        // 1、横向遍历
        for (int i = 0; i < row; i++) {
            int max1 = getRepeatManNumByArr(matrix[i]);
            max = Math.max(max, max1);
        }
        // 2、纵向遍历
        for (int j = 0; j < col; j++) {
            char[] chars = new char[row];
            for (int k = 0; k < row; k++) {
                chars[k] = matrix[k][j];
            }
            int max2 = getRepeatManNumByArr(chars);
            max = Math.max(max, max2);
            // 打印
//            System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
        }
        int max3 = getSlashArrs(matrix);
        max = Math.max(max, max3);
        int max4 = getSlashBackArrs(matrix);
        max = Math.max(max, max4);
        return max;
    }

    private static int getSlashBackArrs(char[][] matrix) {
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int forEachSize = row + col - 1;
        // 4、斜对角遍历
        int x = 0;
        int y = col - 1;
        for (int i = 0; i < forEachSize; i++) {
            LinkedList<Character> chars = new LinkedList<>();
            if (i <= row - 1) {
                x = i;
                y = col - 1;
            } else {
                x = row - 1;
                y--;
            }
            chars.add(matrix[x][y]);
            int xCopy = x;
            int yCopy = y;
            while (xCopy-- > 0 && yCopy-- > 0) {
                chars.add(matrix[xCopy][yCopy]);
            }
            // 转换
            char[] myChars = new char[chars.size()];
            for (int bl = 0; bl < chars.size(); bl++) {
                myChars[bl] = chars.get(bl);
            }
            System.out.println("Arrays.toString(myChars)22 = " + Arrays.toString(myChars));
            max = Math.max(max, getRepeatManNumByArr(myChars));
        }
        return max;
    }

    private static int getSlashArrs(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        // 3、对角遍历
        int forEachSize = row + col - 1;
        int y = 0;
        int x = 0;
        for (int i = 0; i < forEachSize; i++) {
            LinkedList<Character> chars = new LinkedList<>();
            if (i <= row - 1) {
                x = i;
                y = 0;
            } else {
                x = row - 1;
                y++;
            }
            chars.add(matrix[x][y]);
            int xCopy = x;
            int yCopy = y;
            while (xCopy-- > 0 && yCopy++ < col - 1) {
                chars.add(matrix[xCopy][yCopy]);
            }
            char[] myChars = new char[chars.size()];
            for (int bl = 0; bl < chars.size(); bl++) {
                myChars[bl] = chars.get(bl);
            }
            System.out.println("Arrays.toString(myChars)111 = " + Arrays.toString(myChars));
            max = Math.max(max, getRepeatManNumByArr(myChars));
        }
        return max;
    }

    private static int getRepeatManNumByArr(char[] matrix) {
        int max = 0;
        String str = new String(matrix);
        Pattern compile = Pattern.compile("M+");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            max = Math.max(max, group.length());
        }
        return max;
    }
}
