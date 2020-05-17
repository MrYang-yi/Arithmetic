package LeetCode;

import java.util.Arrays;

/**
 * topic:最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {

/*        int min=Math.abs(nums[0]+nums[1]+nums[2]-target);
        int  sum=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(min>Math.abs(nums[i]+nums[j]+nums[k]-target)){
                        min=Math.abs(nums[i]+nums[j]+nums[k]-target);
                        sum=nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }
        return sum;*/
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(target - sum) < Math.abs(target - min))
                    min = sum;
                if (sum > target) {
                    R--;
                } else if (sum < target) {
                    L++;
                } else {
                    return min;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        //int p = new ThreeSumClosest_16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        //int p = new ThreeSumClosest_16().threeSumClosest(new int[]{0,0,0}, 1);
        int p = new ThreeSumClosest_16().threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1);
        System.out.println(p);
    }
}
