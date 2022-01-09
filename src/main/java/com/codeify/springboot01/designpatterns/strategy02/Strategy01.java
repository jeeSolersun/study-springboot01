package com.codeify.springboot01.designpatterns.strategy02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author codeify
 * @since 2021/08/21 23:19
 */
public class Strategy01 {

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 3};
        
        Arrays.sort(arr, (a,  b) -> {
            if(a < b) return -1;
            else if(a > b) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(arr));
    }
}
