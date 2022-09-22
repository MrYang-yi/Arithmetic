package Project.Array;

public class lc283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int p = remove(nums);
        while (p < nums.length) {
            nums[p] = 0;
            p++;
        }
    }

    private int remove(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}