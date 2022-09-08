package HighFrequence.Hot100.leetcode.editor.cn;

public class lc5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new lc5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("tattarrattat"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int start = 0;
            int end = 0;
            //int max = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                int a = findMax(i, i, s);
                int b = findMax(i, i + 1, s);
                //max = Math.max(a, b); //如果这里是求长度，就直接return了
                if (a > end - start +  1) {
                    start = i - a / 2;
                    end = i + a / 2;
                }
                if (b > end - start + 1) {
                    start = i - (b - 1) / 2;
                    end = (i + 1) + (b - 1) / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int findMax(int left, int right, String s) {
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;// (right-left+1)-2  因为当下一次循环不相等时，left和right各自都多走了一步，所以需要-2
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}