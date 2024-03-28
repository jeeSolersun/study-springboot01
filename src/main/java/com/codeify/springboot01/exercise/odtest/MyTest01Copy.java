package com.codeify.springboot01.exercise.odtest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author codeify
 * @since 2022/01/10 20:43
 */
public class MyTest01Copy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
//        String input = scanner.nextLine();
//        String[] split = input.split(" ");
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            try {
                arr[i] = Integer.parseInt(scanner.next());
            } catch(Exception e) {
                System.out.println("-1");
                return;
            }
            if (arr[i] < 0 || arr[i] > 1000) {
                System.out.println("-1");
                return;
            }
        }
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        String s = scanner.nextLine();
        System.out.println("s = " + s);
        int numToPrint = Integer.parseInt(s);
//        System.out.println("numToPrint = " + numToPrint);
        List<Integer> collect = Arrays.stream(arr).distinct().collect(Collectors.toList());
        if (collect.size() < arr.length) {
            System.out.println("-1");
        } else {
            Arrays.sort(arr);
//            Integer[] integers = Arrays.copyOfRange(arr, 0, numToPrint);
//            Integer[] integers2 = Arrays.copyOfRange(arr, num - numToPrint, num);
//            int total = 0;
//            for (int i = 0; i < integers.length; i++) {
//                total += integers[i];
//            }
//            for (int i = 0; i < integers2.length; i++) {
//                total += integers2[i];
//            }
            int total = 0;
            for (int i = 0; i < numToPrint; i++) {
                total += arr[i];
            }
            for (int i = num-numToPrint; i < num; i++) {
                total +=arr[i];
            }
            System.out.println(total);
        }
    }
}
