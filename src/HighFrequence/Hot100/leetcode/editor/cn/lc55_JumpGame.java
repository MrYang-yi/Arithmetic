package HighFrequence.Hot100.leetcode.editor.cn;

public class lc55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new lc55_JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2, 2, 1, 1, 0, 1, 2}));
    }

    /**
     * 不断更新能走到的最远的位置
     */
    class Solution {
        public boolean canJump(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {  //走到的位置 > 能走到的最远位置
                    return false;
                }
                k = Math.max(k, i + nums[i]);
            }
            return true;
        }
    }

}