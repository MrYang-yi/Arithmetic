package HighFrequence.Hot100.leetcode.editor.cn;

public class lc70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new lc70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(3));
    }

    /**
     * 斐波那契数列 f(n)=f(n-1)+f(n-2)
     */
    //爬楼梯
    class Solution {
        public int climbStairs(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            int a = 1;
            int b = 1;
            int c = 2;
            for (int i = 2; i < n + 1; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}