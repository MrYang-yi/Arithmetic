package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class lc128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new lc128_LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    //最长连续序列
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int longest = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {
                    int currentNum = num;
                    int current = 1;
                    while (set.contains(currentNum + 1)) {
                        currentNum += 1;
                        current += 1;
                    }
                    longest = Math.max(longest, current);
                }
            }
            return longest;
        }
    }
}