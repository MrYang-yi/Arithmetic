package HighFrequence.Hot100.leetcode.editor.cn;

public class lc4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new lc4_MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    //寻找两个正序数组的中位数
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int sum = nums1.length + nums2.length;
            int n1 = 0, n2 = 0, val1 = 0, val2 = 0;
            while (n1 + n2 <= sum / 2) {
                val1 = val2;
                if (n1 == nums1.length) {
                    val2 = nums2[n2++];
                } else if (n2 == nums2.length) {
                    val2 = nums1[n1++];
                } else if (nums1[n1] < nums2[n2]) {
                    val2 = nums1[n1++];
                } else {
                    val2 = nums2[n2++];
                }
            }
            return sum % 2 == 1 ? val2 : (val1 + val2) / 2.0;
        }
    }
}