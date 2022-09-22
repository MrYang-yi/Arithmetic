package Project.Array;

public class lc26_RemoveDuplicatesFromSortedArray {
    /**
     * 比较 left 和 right 位置的元素是否相等,如果相等，right 后移 1 位
     * 如果不相等，将 right 位置的元素复制到 left+1 位置上，left 后移一位，right 后移 1 位
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                if (right - left > 1) { //优化 当出现了重复的情况才需要调换位置
                    nums[left + 1] = nums[right];
                }
                left++;
            }
            right++;
        }
        return left + 1;
    }
}