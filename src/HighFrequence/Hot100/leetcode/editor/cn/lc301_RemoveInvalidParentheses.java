package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//回溯+剪枝
//删除无效的括号
public class lc301_RemoveInvalidParentheses {
    private List<String> list = new ArrayList<String>();

    public List<String> removeInvalidParentheses(String s) {
        int leftremove = 0;
        int rightremove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftremove++;
            } else if (s.charAt(i) == ')') {
                if (leftremove == 0) {
                    rightremove++;
                } else {
                    leftremove--;
                }
            }
        }
        helper(s, 0, leftremove, rightremove);
        return list;
    }

    private void helper(String str, int start, int leftremove, int rightremove) {
        if (leftremove == 0 && rightremove == 0) {
            if (isValid(str)) {
                list.add(str);
            }
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (leftremove + rightremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (leftremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, leftremove - 1, rightremove);
            }
            // 尝试去掉一个右括号
            if (rightremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, leftremove, rightremove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}