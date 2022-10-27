package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new lc17_LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23").forEach(System.out::println);
    }

    //电话号码的字母组合
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return list;
            }
            Map<Integer, String> map = new HashMap<>();
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            dfs(list, map, digits, 0, new StringBuffer());
            return list;
        }
    }

    private void dfs(List<String> list, Map<Integer, String> map, String digits, int depth, StringBuffer stringBuffer) {
        if (depth == digits.length()) {
            list.add(stringBuffer.toString());
        } else {
            String floor = map.get(Integer.parseInt(String.valueOf(digits.charAt(depth)))); //拿到当前一层的所有值
            for (int i = 0; i < floor.length(); i++) {
                stringBuffer.append(floor.charAt(i));  //添加当前层的第一个值
                dfs(list, map, digits, depth + 1, stringBuffer);  //开始回溯
                stringBuffer.deleteCharAt(depth);
            }
        }
    }
}