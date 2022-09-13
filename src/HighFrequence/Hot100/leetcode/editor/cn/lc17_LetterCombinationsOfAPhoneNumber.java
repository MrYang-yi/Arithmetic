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

    //leetcode submit region begin(Prohibit modification and deletion)
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
            backTrack(list, map, digits, 0, new StringBuffer());
            return list;
        }
    }

    private void backTrack(List<String> list, Map<Integer, String> map, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            list.add(stringBuffer.toString());
        } else {
            String floor = map.get(Integer.parseInt(String.valueOf(digits.charAt(index)))); //拿到当前一层的所有值
            for (int i = 0; i < floor.length(); i++) {
                stringBuffer.append(floor.charAt(i));  //添加当前层的第一个值
                backTrack(list, map, digits, index + 1, stringBuffer);  //开始回溯
                stringBuffer.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}