package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class test61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                count++; // 统计大小王数量
            } else if (nums[i] == nums[i + 1]) {
                return false; // 若有重复，提前返回 false
            }
        }
        return nums[4] - nums[count] < 5;

    }

    public static void main(String[] args) {
        boolean flag = new test61().isStraight(new int[]{1, 2, 3, 4, 5});
        System.out.println(flag);
    }
}
