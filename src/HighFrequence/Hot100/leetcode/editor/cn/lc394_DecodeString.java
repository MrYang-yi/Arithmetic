package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Stack;

public class lc394_DecodeString {
    public static void main(String[] args) {
        Solution solution = new lc394_DecodeString().new Solution();
        System.out.println(solution.decodeString("100[leetcode]"));
    }

    //字符串解码
    class Solution {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            Stack<Integer> stack_multi = new Stack<>();
            Stack<String> stack_res = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c == '[') {
                    stack_multi.add(multi);
                    stack_res.add(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int cur_multi = stack_multi.pop();
                    for (int i = 0; i < cur_multi; i++) {
                        tmp.append(res);
                    }
                    res = new StringBuilder(stack_res.pop() + tmp);
                } else if (Character.isDigit(c)) { //可能是连续的数字
                    multi = multi * 10 + Integer.parseInt(c + "");
                } else {
                    res.append(c);
                }
            }
            return res.toString();
        }
    }
}