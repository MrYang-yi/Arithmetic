package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Stack;

//最长有效括号
public class lc32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxres = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxres = Math.max(maxres, i - stack.peek());
                }
            }
        }
        return maxres;
    }
}