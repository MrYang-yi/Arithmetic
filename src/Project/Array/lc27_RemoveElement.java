package Project.Array;

public class lc27_RemoveElement {
    /**
     * 右指针等于val时，不用管，直接后移一位，如果不等于就要调换位置
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}