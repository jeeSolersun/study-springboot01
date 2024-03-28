package com.codeify.springboot01.util;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author codeify
 * @since 2023/02/08 00:41
 */
public class MyUtils {
public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(3);
        deque.push(2);
        deque.push(5);
        System.out.println("deque = " + deque);
        System.out.println("deque.peek() = " + deque.peek());
        deque.addLast(10);
        System.out.println("deque = " + deque);
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque = " + deque);

    }

    private static void test01() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);
    }
}
