package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.*;

public class lc22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new lc22_GenerateParentheses().new Solution();
        solution.generateParenthesis(3).forEach(System.out::println);

    }

    //括号生成
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            if (n == 0) {
                return list;
            }
            dfs(new StringBuffer(), n, n, list);
            return list;
        }

        private void dfs(StringBuffer stringBuffer, int left, int right, List<String> list) {
            if (left == 0 && right == 0) {
                list.add(stringBuffer.toString());
                return;
            }
            // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
            if (left > right) {
                return;
            }
            if (left > 0) {
                stringBuffer.append("(");
                dfs(stringBuffer, left - 1, right, list);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            if (right > 0) {
                stringBuffer.append(")");
                dfs(stringBuffer, left, right - 1, list);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
    }
}
