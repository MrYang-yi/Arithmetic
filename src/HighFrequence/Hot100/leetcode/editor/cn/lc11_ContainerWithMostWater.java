package HighFrequence.Hot100.leetcode.editor.cn;

public class lc11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new lc11_ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 双指针解决  首先宽度肯定是越来越窄的
     * 宽 = end - start ; 长 = min (heigth[start],height[end])
     * 即谁的高度更矮 谁去移动
     */
//盛最多水的容器
    class Solution {
        public int maxArea(int[] height) {
            int start = 0;
            int end = height.length - 1;
            int max = 0;
            while (start < end) {
                if (max < (end - start) * Math.min(height[start], height[end])) {
                    max = (end - start) * Math.min(height[start], height[end]);
                }
                if (height[start] < height[end]) {
                    start++;
                } else {
                    end--;
                }
            }
            return max;
        }
    }


}