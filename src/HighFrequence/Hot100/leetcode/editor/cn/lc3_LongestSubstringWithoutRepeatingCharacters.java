package LeetCode.editor.cn.HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashMap;

public class lc3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new lc3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int maxValue = 0;
        int start = 0 ;
        int end = 0 ;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),)
        }
        return maxValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}