package LeetCode;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j = j + 2) {  //这里需要注意 因为j是取不到的 所以可以用 =
                if (Isvalid(s.substring(i, j))) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    private boolean Isvalid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {  //遇到')' 栈不为空 并且栈顶元素是'('
                stack.pop();
            } else {                   //遇到')' 不符合上面条件的 都是不符合有效括号的情况
                return false;
            }
        }
        return stack.empty();
    }



    public static void main(String[] args) {
        int p = new LongestValidParentheses().longestValidParentheses("(()");
        System.out.println(p);
    }
}
