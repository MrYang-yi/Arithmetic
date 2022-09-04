package HighFrequence.swordPointToOffer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class test53_2 {
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] == middle) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int a = new test53_2().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9});
        System.out.println(a);
    }
}
