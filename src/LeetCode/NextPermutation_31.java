package LeetCode;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。

 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 思路：这道题的意思是  找出一个比当前排列数大 且可能最小的数
 *        例如2 3 1 5 2它的下一个排列是 2 3 2 1 5
 *        而在你进行操作时 会从最后一位开始操作 所以就容易变成 2 3  2 5 1
 *        其实他们的差别就在与最后一位与它的交换位后面的一群数字  只要对这些数字进行一次排序就行
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }

        }
        Arrays.sort(nums);
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        new NextPermutation_31().nextPermutation(new int[]{3, 2, 1});
    }
}