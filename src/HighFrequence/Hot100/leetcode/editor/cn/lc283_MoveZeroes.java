package HighFrequence.Hot100.leetcode.editor.cn;

public class lc283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new lc283_MoveZeroes().new Solution();
        int[] a = {0, 1, 0, 3, 12};
        solution.moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }

    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int p = remove(nums);
            while (p < nums.length) {
                nums[p] = 0;
                p++;
            }
        }

        private int remove(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
            return left;
        }
    }

}