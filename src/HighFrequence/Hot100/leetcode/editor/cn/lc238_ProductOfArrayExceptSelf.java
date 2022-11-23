package HighFrequence.Hot100.leetcode.editor.cn;

public class lc238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new lc238_ProductOfArrayExceptSelf().new Solution();
        System.out.println(solution.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    /**
     * 时间复杂度：O(N)  空间复杂度：O(1)
     */
    //除自身以外数组的乘积
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] answer = new int[length];
            // answer[i] 表示索引 i 左侧所有元素的乘积
            // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
            answer[0] = 1;
            for (int i = 1; i < length; i++) {
                answer[i] = nums[i - 1] * answer[i - 1];
            }
            // R 为右侧所有元素的乘积
            // 刚开始右边没有元素，所以 R = 1
            int R = 1;
            for (int i = length - 1; i >= 0; i--) {
                // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
                answer[i] = answer[i] * R;
                // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
                R *= nums[i];
            }
            return answer;
        }
    }
}