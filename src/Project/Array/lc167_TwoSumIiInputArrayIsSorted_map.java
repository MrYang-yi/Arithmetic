package Project.Array;

import java.util.HashMap;

public class lc167_TwoSumIiInputArrayIsSorted_map {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1}; //因为题目数组的下标是从1开始的
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}