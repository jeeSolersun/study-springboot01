package com.codeify.springboot01.streamTest;

import java.util.Arrays;

/**
 * created by sunhanbing on 2021/06/20 21:43
 */
public class MyTest {

    public static void main(String[] args) {
        /*String s = "hello";
        Object o = s;
        String s1 = (String)o;
        System.out.println(o);
        System.out.println(s1);*/
        Object[] o = new Object[]{"a", "b"};
        String[] sArr = new String[o.length];
//        System.out.println(sArr);
        System.arraycopy(o, 0, sArr, 0, o.length);
        System.out.println(Arrays.asList(sArr));
        // Arrays.asList()
        String[] s1 = Arrays.asList(o).toArray(new String[0]);
        System.out.println(Arrays.asList(o).toArray());
        System.out.println(s1 instanceof String[]);
        System.out.println(Arrays.asList(s1));
        // Arrays.stream()
        String[] s = Arrays.stream(o).toArray(String[]::new);
        System.out.println(s instanceof String[]);
        System.out.println(s);
    }
}
