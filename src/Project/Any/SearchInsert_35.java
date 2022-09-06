package Project.Any;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 思路： 1 暴力求解
 *       2 因为题目涉及到排序数组 所以可以用二分查找
 *        两种做法的时间复杂度是一样的
 */
public class SearchInsert_35 {

    public int searchInsert(int[] nums, int target) {
/*        if (nums == null || nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        if (nums[0] > target) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (i < nums.length - 1 && nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return -1;*/
        if (nums == null || nums.length == 0) return 0;
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int i = 0;
        int j = nums.length;
        int middle = 0;
        while (i < j) {
            middle = (i + j) / 2;
            if (nums[middle] < target) {
                i = middle + 1;
            } else if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                j = middle - 1;
            }
        }
        return nums[middle] > target ? middle : middle + 1;

    }

    public static void main(String[] args) {
        int p = new SearchInsert_35().searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(p);
    }
}
