package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashMap;

public class lc3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new lc3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //无重复字符的最长子串
    //最长不重复子串
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int maxValue = 0;
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                if (map.containsKey(s.charAt(right))) {
                    if (map.get(s.charAt(right)) + 1 > left) { //注意这里的left容易出错 直接就写 left=map.get(s.charAt(right))+1，left更新，只能往右移,不能往左退
                        left = map.get(s.charAt(right)) + 1;
                    }
                }
                maxValue = Math.max(maxValue, right - left + 1);
                map.put(s.charAt(right), right);
            }
            return maxValue;
        }
    }
}