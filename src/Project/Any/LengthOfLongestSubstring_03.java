package Project.Any;

import java.util.HashMap;

/**
 * topic:无重复子串的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 */
public class LengthOfLongestSubstring_03 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start=0;
        int end=0;
        for (end=0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start,map.get(s.charAt(end))+1);  //靠左边重复的数向右移一位
            }
            maxLength = Math.max(maxLength, end - start+1);
            map.put(s.charAt(end), end);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        //Project.String s = "abcdbacdebb";
        String s="abba";
        int p = lengthOfLongestSubstring(s);
        System.out.println(p);
    }
}
