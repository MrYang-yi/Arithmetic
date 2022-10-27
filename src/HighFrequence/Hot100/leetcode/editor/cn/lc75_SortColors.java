package HighFrequence.Hot100.leetcode.editor.cn;

public class lc75_SortColors {
    public static void main(String[] args) {
        Solution solution = new lc75_SortColors().new Solution();
        solution.sortColors(new int[]{2, 0, 2, 1, 1, 0});

    }

    //颜色分类
    class Solution {
        public void sortColors(int[] nums) {
            int p = 0, q = nums.length - 1;
            for (int i = 0; i <= q; ++i) {
                if (nums[i] == 0) {
                    nums[i] = nums[p];
                    nums[p] = 0;
                    ++p;
                }
                if (nums[i] == 2) {
                    nums[i] = nums[q];
                    nums[q] = 2;
                    --q;
                    if (nums[i] != 1) {
                        --i;
                    }
                }
            }
            return;
        }
    }
}