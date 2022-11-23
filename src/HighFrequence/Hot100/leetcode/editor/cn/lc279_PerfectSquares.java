package HighFrequence.Hot100.leetcode.editor.cn;

public class lc279_PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new lc279_PerfectSquares().new Solution();
        System.out.println(solution.numSquares(12));
    }

    /**
     * f[i] 表示最少需要多少个数的平方来表示整数i
     * 时间复杂度：O(n根号n)  空间复杂度O(n)

     */
    //完全平方数
    class Solution {
        public int numSquares(int n) {
            int[] f = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, f[i - j * j]);
                }
                f[i] = min + 1;
            }
            return f[n];
        }
    }
}