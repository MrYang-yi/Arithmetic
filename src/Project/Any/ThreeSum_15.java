package Project.Any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * topic:三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            int target = -nums[i];
            while (L < R) {
                if (nums[L] + nums[R] == target) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[L]);
                    curr.add(nums[R]);
                    list.add(curr);
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (nums[L] + nums[R] < target) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return list;

    }

   public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> list = new ThreeSum_15().threeSum(nums);
        System.out.println(list);

    }

}
