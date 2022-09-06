package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class test53_1 {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] < target) {
                i = middle + 1;
            } else if (nums[middle] == target) {
                int left = middle;
                int right = middle;
                while (left >= 1 && nums[left - 1] == target) left--;
                while (right <= nums.length - 2 && nums[right + 1] == target) right++;
                return right - left + 1;
            } else if (nums[middle] > target) {
                j = middle - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a = new test53_1().search(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(a);
    }
}
