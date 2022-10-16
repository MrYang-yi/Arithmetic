package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.*;

public class lc49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new lc49_GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (String str: strs){
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}