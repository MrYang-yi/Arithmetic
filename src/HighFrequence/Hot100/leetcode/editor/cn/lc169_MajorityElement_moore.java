package HighFrequence.Hot100.leetcode.editor.cn;

public class lc169_MajorityElement_moore {
    public static void main(String[] args) {
        Solution solution = new lc169_MajorityElement_moore().new Solution();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * 摩尔投票法 碰到相同的数，加1票，否则减1票，如果票数为0，则重置众数
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int mostNum = nums[0];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    mostNum = nums[i];
                }
                count += (nums[i] == mostNum) ? 1 : -1;
            }
            return mostNum;
        }
    }
}