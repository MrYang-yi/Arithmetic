package HighFrequence.Hot100.leetcode.editor.cn;

public class lc338_CountingBits {
    public static void main(String[] args) {
        Solution solution = new lc338_CountingBits().new Solution();
        int[] nums = solution.countBits(5);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
    }

    /**
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1
     * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
     *      因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
     */
    class Solution {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            result[0] = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) {
                    result[i] = result[i - 1] + 1;
                } else {
                    result[i] = result[i / 2];
                }
            }
            return result;
        }
    }

}