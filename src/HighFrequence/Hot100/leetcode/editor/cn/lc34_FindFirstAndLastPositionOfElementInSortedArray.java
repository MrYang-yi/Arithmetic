package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;

public class lc34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new lc34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(Arrays.stream(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).boxed().collect(Collectors.toList()));
    }

    //在排序数组中查找元素的第一个和最后一个位置
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int[] num = new int[2];
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    num[0] = mid;
                    num[1] = mid;
                    int slow = mid - 1;
                    int fast = mid + 1;
                    while (slow >= 0 && nums[slow] == target) {
                        num[0] = slow;
                        slow--;
                    }
                    while (fast <= nums.length - 1 && nums[fast] == target) {
                        num[1] = fast;
                        fast++;
                    }
                    return num;
                } else {
                    left = mid + 1;
                }
            }
            return new int[]{-1, -1};
        }
    }
}