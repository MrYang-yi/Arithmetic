package LeetCode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int i = 0;
        int j = nums.length - 1 ;
        int left;
        int right;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] > target) {
                j = middle - 1;
            } else if (nums[middle] == target) {
                left = middle;
                while (left >= 1 && nums[left - 1] == target) {
                    left--;
                }
                right = middle;
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                return new int[]{left, right};
            } else if (nums[middle] < target) {
                i = middle + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] a = new SearchRange_34().searchRange(new int[]{2, 2}, 3);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
