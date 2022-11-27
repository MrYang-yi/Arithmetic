package HighFrequence.Hot100.leetcode.editor.cn;

public class lc416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new lc416_PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }

    //分割等和子集
    //动态规划
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length < 2) {
                return false;
            }
            int sum = 0;
            int maxNum = 0;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            if ((sum & 1) == 1) {  //不为偶数
                return false;
            }
            int target = sum / 2;
            if (maxNum > target) {
                return false;
            }
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                for (int j = target; j >= num; --j) {
                    dp[j] |= dp[j - num];
                }
            }
            return dp[target];
        }
    }
}