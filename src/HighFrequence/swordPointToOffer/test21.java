package HighFrequence.swordPointToOffer;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class test21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 1) return nums;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while (i < j && (nums[j] & 1) != 1) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = new test21().exchange(new int[]{1, 2, 3, 4, 5, 6, 7});
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
