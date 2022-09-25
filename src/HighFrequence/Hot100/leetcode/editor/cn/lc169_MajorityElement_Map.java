package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.HashMap;

public class lc169_MajorityElement_Map {
    public static void main(String[] args) {
        Solution solution = new lc169_MajorityElement_Map().new Solution();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.getOrDefault(nums[i], 0) > nums.length / 2) {
                    return nums[i];
                }
            }
            return -1;
        }
    }
}