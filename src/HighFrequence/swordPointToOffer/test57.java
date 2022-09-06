package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
 * 。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 */
public class test57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum < target) {
                i++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] a = new test57().twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int x : a) {
            System.out.println(x + " ");
        }
    }
}
