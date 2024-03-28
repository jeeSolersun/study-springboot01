package com.codeify.springboot01.exercise.exam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * created by sunhanbing on 2021/07/20 21:52
 */
public class CalcString {

    public static void main(String[] args) {
        // 2 -17,-5 = -34, -10
        // 6 20 = -14
        // -2,2 5 = -10,10
        List<Integer> result = calcExpression("2*3-4*5");
        System.out.println(result);
    }

    public static List<Integer> calcExpression(String expression){
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = 0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                String lString = expression.substring(0, i);
                String rString = expression.substring(i + 1);
                List<Integer> list1 = calcExpression(lString);
                List<Integer> list2 = calcExpression(rString);
                Iterator<Integer> iter1 = list1.iterator();
                Iterator<Integer> iter2 = list2.iterator();
                while (iter1.hasNext()){
                    Integer next1 = iter1.next();
                    while(iter2.hasNext()){
                        Integer next2 = iter2.next();
                        if(c == '+'){
                            result.add(next1 + next2);
                        }else if(c == '-'){
                            result.add(next1 - next2);
                        }else if(c == '*'){
                            result.add(next1 * next2);
                        }
                    }
                }
                /*list1.stream().forEach((item1) -> {
                    list2.stream().forEach((item2) -> {
                        if(c == '+'){
                            result.add(item1 + item2);
                        }else if(c == '-'){
                            result.add(item1 - item2);
                        }else if(c == '*'){
                            result.add(item1 * item2);
                        }
                    });
                });*/
            }
        }
        if(result.size() == 0){
            result.add(Integer.valueOf(expression));
        }
        return result;
    }
}
