package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class lc448_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new lc448_FindAllNumbersDisappearedInAnArray().new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    /**
     * 遍历nums，每遇到一个数x,就让nums[x-1]增加n，由于nums中所有数均在[1，n]中，
     * 增加后这些数必然大于n，如果不大于n，就说明从没遇到过i+1的数
     */
    //找到所有数组中消失的数字
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int num : nums) {
                int x = (num - 1) % n;
                nums[x] += n;
            }
            List<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) {
                    ret.add(i + 1);
                }
            }
            return ret;
        }
    }
}