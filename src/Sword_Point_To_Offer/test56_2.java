package Sword_Point_To_Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class test56_2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> hashmap:map.entrySet()){
            if(hashmap.getValue() == 1) return hashmap.getKey();
        }
         return -1;
    }
    public static void main(String[] args) {
        int a = new test56_2().singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7});
        System.out.println(a);
    }
}
