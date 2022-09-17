package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;

public class lc31_NextPermutation_cannot {
    public static void main(String[] args) {
        Solution solution = new lc31_NextPermutation_cannot().new Solution();
        solution.nextPermutation(new int[]{1, 2, 3});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)

}