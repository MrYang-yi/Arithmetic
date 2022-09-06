package Project.Any;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == n * 2) {
            list.add(cur.toString());
            return;
        }

        if (open < n) {
            cur.append('(');
            backtrack(list, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(list, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> list = new GenerateParenthesis_22().generateParenthesis(3);
        for (String x : list) {
            System.out.println(x);
        }
    }
}
