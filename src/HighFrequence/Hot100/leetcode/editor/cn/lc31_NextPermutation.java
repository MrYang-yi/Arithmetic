package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;

public class lc31_NextPermutation {
    public static void main(String[] args) {
        Solution solution = new lc31_NextPermutation().new Solution();
        int[] a = {1, 2, 3};
        solution.nextPermutation(a);
        System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
    }

    class Solution {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }

            }
            Arrays.sort(nums);
        }

        void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}