package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new lc47_PermutationsIi().new Solution();
        System.out.println(solution.resultuteUnique(new int[]{1, 1, 2}));
    }

    class Solution {
        public List<List<Integer>> resultuteUnique(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            if (nums.length == 0) {
                return list;
            }
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);  //46不需要排序
            backTrack(list, 0, nums, result, used);
            return list;
        }

        private void backTrack(List<List<Integer>> list, int index, int[] nums, List<Integer> result, boolean[] used) {
            if (index == nums.length) {
                list.add(new ArrayList<>(result));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {  //要保证的是不重复的全排列
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