package com.codeify.springboot01.exercise.leetcode.single_stack;

import com.codeify.springboot01.exercise.leetcode.MyInputUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

/**
 * 739.每日温度
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author codeify
 * @since 2023/02/05 17:34
 */
public class Demo739 {
    public static void main(String[] args) {
        MyInputUtils.cyclicInputArr((val) -> {
            int[] ints = Stream.of(val).mapToInt(item -> (Integer) item).toArray();
            System.out.println("Arrays.toString(val) = " + Arrays.toString(ints));
            //
            int[] res = dailyTemperatures(ints);
            System.out.println("Arrays.toString(res) = " + Arrays.toString(res));

            return null;
        });
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peekLast()]) {
                int index = stack.pollLast();
                answer[index] = i - index;
            }
            stack.addLast(i);
        }
        return answer;
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peekFirst()]) {
                int index = stack.pollFirst();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        return answer;
    }

    /**
     * 暴力解法
     *
     * @param temperatures 入参
     * @return 结果
     */
    public static int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            int j = i;
            while (j++ < len - 1) {
                if (temperatures[j] > temp) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
}
