package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

import java.util.ArrayList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class test59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)  return new int[0];
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length - k + 1) {
            list.add(getMax(nums, k, i));
            i++;
        }
        int[] a = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            a[j] = list.get(j);
        }
        return a;
    }

    private int getMax(int[] nums, int k, int a) {
        int max = Integer.MIN_VALUE;
        for (int i = a; i < k + a ; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new test59_1().maxSlidingWindow(new int[]{}, 0);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
