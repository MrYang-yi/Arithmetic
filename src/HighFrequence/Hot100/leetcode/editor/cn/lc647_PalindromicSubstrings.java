package HighFrequence.Hot100.leetcode.editor.cn;

public class lc647_PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new lc647_PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("aaa"));
    }

    //回文子串
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length(), ans = 0;
            for (int i = 0; i < 2 * n - 1; ++i) {
                int l = i / 2;
                int r = i / 2 + i % 2;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    --l;
                    ++r;
                    ++ans;
                }
            }
            return ans;
        }
    }
}