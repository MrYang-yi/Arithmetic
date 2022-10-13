package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class lc46_Permutations {
    public static void main(String[] args) {
        Solution solution = new lc46_Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            if (nums.length == 0) {
                return list;
            }
            boolean[] used = new boolean[nums.length];
            backTrack(list, 0, nums, result, used);
            return list;
        }

        private void backTrack(List<List<Integer>> list, int index, int[] nums, List<Integer> result, boolean[] used) {
            if (index == nums.length) {
                list.add(new ArrayList<>(result));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                result.add(nums[i]);
                used[i] = true;
                backTrack(list, index + 1, nums, result, used);
                result.remove(index);
                used[i] = false;
            }
        }
    }
}