package Project.Array;

public class lc303_RangeSumQueryImmutable {
    class NumArray {
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            while (left <= right) {
                sum += nums[left];
                left++;
            }
            return sum;
        }
    }

}