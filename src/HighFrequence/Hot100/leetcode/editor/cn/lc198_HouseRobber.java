package HighFrequence.Hot100.leetcode.editor.cn;

public class lc198_HouseRobber {
    public static void main(String[] args) {
        Solution solution = new lc198_HouseRobber().new Solution();
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));

    }

    /**
     * 利用滚动数组的思想
     * 在每个时刻只需要存储前两间房屋的最高总金额
     */
    //打家劫舍
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int first = nums[0];
            int second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }

}