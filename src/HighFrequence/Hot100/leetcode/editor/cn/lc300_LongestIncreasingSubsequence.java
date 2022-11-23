package HighFrequence.Hot100.leetcode.editor.cn;

public class lc300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new lc300_LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

    }

    /**
     * dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度
     * 时间复杂度O(n^2) 空间复杂度O(n)
     */
    //最长递增子序列
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}