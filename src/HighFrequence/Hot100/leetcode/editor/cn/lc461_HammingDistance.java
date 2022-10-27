package HighFrequence.Hot100.leetcode.editor.cn;

public class lc461_HammingDistance {
    public static void main(String[] args) {
        Solution solution = new lc461_HammingDistance().new Solution();
        System.out.println(solution.hammingDistance(3, 5));
    }

    //汉明距离
    class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
}