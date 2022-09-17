package HighFrequence.Hot100.leetcode.editor.cn;

public class lc136_SingleNumber {
    public static void main(String[] args) {
        Solution solution = new lc136_SingleNumber().new Solution();
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    /**
     * 不用额外的存储空间，有这句话就需要想到异或
     * 异或：a^a = 0 ,0^a = 0
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}