package HighFrequence.Hot100.leetcode.editor.cn;

public class lc53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new lc53_MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    //最大子数组和
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxAll = nums[0];  //记录n个数的最大值
            int maxCur = 0;  //记录n个数是否包含第n个数的最大值
            for (int i = 0; i < nums.length; i++) {
                maxCur = Math.max(maxCur + nums[i], nums[i]);
                maxAll = Math.max(maxAll, maxCur);
            }
            return maxAll;
        }
    }
}