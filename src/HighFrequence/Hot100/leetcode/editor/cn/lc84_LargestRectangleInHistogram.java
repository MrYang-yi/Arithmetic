package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

//单调栈
//柱状图中最大的矩形
public class lc84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            count = Math.max(count, (right[i] - left[i] - 1) * heights[i]);
        }
        return count;
    }
}