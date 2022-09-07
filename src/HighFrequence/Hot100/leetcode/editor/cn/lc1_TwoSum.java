package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class lc1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new lc1_TwoSum().new Solution();
        int[] array = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.asList(array).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}