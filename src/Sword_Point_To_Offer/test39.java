package Sword_Point_To_Offer;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 惊！ 本题来个摩尔投票法 思路见下
 */
public class test39 {
    public int majorityElement(int[] nums) {
/*        if(nums.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            for (Map.Entry<Integer, Integer> hashmap : map.entrySet()) {
                if (hashmap.getValue() > (nums.length / 2)) {
                    return hashmap.getKey();
                }
            }
        }
        return -1;*/
        if (nums.length == 0) return -1;
        int x = 0; //众数
        int votes = 0; //票数
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                x = nums[i];
            }
            nums[i] = nums[i] == x ? 1 : -1;  //若遍历到的数等于众数 票数+1 不然票数 -1
            votes +=nums[i];
        }
        return  x;
    }

    public static void main(String[] args) {
        int a = new test39().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(a);
    }
}
