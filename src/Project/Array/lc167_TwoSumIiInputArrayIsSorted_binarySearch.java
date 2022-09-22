package Project.Array;

public class lc167_TwoSumIiInputArrayIsSorted_binarySearch {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (target - numbers[i] > numbers[mid]) {
                    left = mid + 1;
                } else if (target - numbers[i] == numbers[mid]) {
                    return new int[]{i + 1, mid + 1}; //因为题目数组的下标是从1开始的
                } else {
                    right = mid - 1;
                }
            }
        }
        return null;
    }
}