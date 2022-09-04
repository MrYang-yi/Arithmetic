package HighFrequence.swordPointToOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 面试题45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class test45 {
    public String minNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ans, new comp());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            str.append(ans[i]);
        }
        return str.toString();
    }

    // 将数组按照这个比较器排序就可以得到答案了
    class comp implements Comparator<String> {
        public int compare(String m, String n) {
            String s1 = m + n;
            String s2 = n + m;
            return s1.compareTo(s2);
        }
    }


    public static void main(String[] args) {
        String s = new test45().minNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }
}
