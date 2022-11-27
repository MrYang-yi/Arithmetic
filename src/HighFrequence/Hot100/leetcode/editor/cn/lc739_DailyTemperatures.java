package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Stack;

public class lc739_DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new lc739_DailyTemperatures().new Solution();
        System.out.println(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    /**
     * 单调栈
     */
    //每日温度
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                int temperature = temperatures[i];
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    int prevIndex = stack.pop();
                    ans[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}