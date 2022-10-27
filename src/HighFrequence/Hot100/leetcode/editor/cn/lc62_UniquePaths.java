package HighFrequence.Hot100.leetcode.editor.cn;


public class lc62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new lc62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(23, 12));
    }

    /**
     * 总用移动m+n-2步，向下移动m-1，向右移动n-1
     * 相当于求m+n-2中m-1步的可能 数学里的排列组合问题C(m+n-2)取m-1
     * 即算  （m+n-2）!
     *     ------------
     *     (m-1)!(n-1)!
     */
    //不同路径
    class Solution {
        public int uniquePaths(int m, int n) {
            long ans = 1;
            for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
                ans *= m + n - 2 - i;
                ans /= i + 1;
            }
            return (int) ans;
        }
    }
}
