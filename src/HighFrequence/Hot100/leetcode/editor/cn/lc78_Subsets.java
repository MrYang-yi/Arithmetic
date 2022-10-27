package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class lc78_Subsets {
    public static void main(String[] args) {
        Solution solution = new lc78_Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //子集
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            dfs(nums, 0, res, list);
            return list;
        }

        private void dfs(int[] nums, int depth, List<Integer> res, List<List<Integer>> list) {
            if (depth == nums.length) {
                list.add(new ArrayList<Integer>(res));
                return;
            }
            res.add(nums[depth]);
            dfs(nums, depth + 1, res, list);
            res.remove(res.size() - 1);
            dfs(nums, depth + 1, res, list);
        }
    }
}