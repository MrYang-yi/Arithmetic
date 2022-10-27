package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class lc39_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new lc39_CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    //组合总和
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> combine = new ArrayList<Integer>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int depth) {
            if (depth == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            // 直接跳过
            dfs(candidates, target, ans, combine, depth + 1);
            // 选择当前数
            if (target - candidates[depth] >= 0) {
                combine.add(candidates[depth]);
                dfs(candidates, target - candidates[depth], ans, combine, depth);
                combine.remove(combine.size() - 1);
            }
        }
    }
}