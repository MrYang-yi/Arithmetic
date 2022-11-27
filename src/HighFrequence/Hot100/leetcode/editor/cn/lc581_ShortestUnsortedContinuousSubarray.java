package HighFrequence.Hot100.leetcode.editor.cn;

public class lc581_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new lc581_ShortestUnsortedContinuousSubarray().new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    //最短无序连续子数组
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int maxNumber = Integer.MIN_VALUE, right = -1;
            int minNumber = Integer.MAX_VALUE, left = -1;
            for (int i = 0; i < n; i++) {
                if (maxNumber > nums[i]) {  //maxNumber:已经遍历过的数中最大值
                    right = i; //可理解为:前一项比当前项大时,该数组不为升序数组,并记录当前项.  遍历一次后,right即为最后一个使之不为升序数组的数.left同理
                } else {
                    maxNumber = nums[i];
                }
                if (minNumber < nums[n - i - 1]) {
                    left = n - i - 1;
                } else {
                    minNumber = nums[n - i - 1];
                }
            }
            return right == -1 ? 0 : right - left + 1;
        }
    }
}