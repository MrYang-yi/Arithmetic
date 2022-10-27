package HighFrequence.Hot100.leetcode.editor.cn;

public class lc33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new lc33_SearchInRotatedSortedArray().new Solution();
        System.out.println(solution.search(new int[]{1}, 1));

    }

    //搜索旋转排序数组
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                if (nums[left] < target) {
                    left++;
                } else if (nums[left] == target) {
                    return left;
                } else if (nums[right] == target) {
                    return right;
                } else {
                    right--;
                }
            }
            return -1;
        }
    }
}