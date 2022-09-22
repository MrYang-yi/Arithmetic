package Project.Array;

public class lc167_TwoSumIiInputArrayIsSorted_doublePointer {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum == target) {
                return new int[]{left + 1, right + 1}; //因为题目数组的下标是从1开始的
            } else {
                left++;
            }
        }
        return null;
    }
}