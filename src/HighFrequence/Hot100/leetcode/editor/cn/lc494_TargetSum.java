package HighFrequence.Hot100.leetcode.editor.cn;

public class lc494_TargetSum {
    public static void main(String[] args) {
        Solution solution = new lc494_TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /**
     * 回溯
     */
    //目标和
    class Solution {
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
            backtrack(nums, target, 0, 0);
            return count;
        }

        public void backtrack(int[] nums, int target, int index, int sum) {
            if (index == nums.length) {
                if (sum == target) {
                    count++;
                }
            } else {
                backtrack(nums, target, index + 1, sum + nums[index]);
                backtrack(nums, target, index + 1, sum - nums[index]);
            }
        }
    }
}