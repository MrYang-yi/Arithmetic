package HighFrequence.Hot100.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lc20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new lc20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("()[]{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    Character character = stack.isEmpty() ? '#' : stack.pop();
                    if (character != map.get(s.charAt(i))) {
                        return false;
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}