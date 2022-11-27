package HighFrequence.Hot100.leetcode.editor.cn;

/**
 * 双指针
 * 原理：如果一端有更高的条形块（例如右端），那积水的高度依赖于当前方向的高度，当右侧的条形块不是最高的，就从相反的方向遍历
 * leftMax,rightMax 记录从左遍历到右边的条形块的最大值 与 从右遍历到左边的条形块的最大值
 */
//接雨水
public class lc42_TrappingRainWater {
    public int trap(int[] height) {
        int count = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {   //如果碰到左边的柱子低于右边
                if (height[left] > leftMax) {
                    leftMax = height[left]; //更新从左遍历到右条形块的最大值
                } else {   //说明有低洼，可以存雨水
                    count += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    count += rightMax - height[right];
                }
                right--;
            }
        }
        return count;
    }
}