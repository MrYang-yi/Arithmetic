package Project.Array;

import java.util.*;

public class lc40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new lc40_CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
    class Solution {
        List<int[]> freq = new ArrayList<int[]>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> sequence = new ArrayList<Integer>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            Arrays.sort(candidates);
            Deque<Integer> path = new ArrayDeque<>(len);
            dfs(candidates, len, 0, target, path, res);
            return res;
        }

        private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.addLast(candidates[i]);
                dfs(candidates, len, i + 1, target - candidates[i], path, res);
                path.removeLast();
            }
        }
    }
}