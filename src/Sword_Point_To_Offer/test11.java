package Sword_Point_To_Offer;

import java.util.Arrays;

/**
 *
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class test11 {
    public int minArray(int[] numbers) {
       Arrays.sort(numbers);
        return numbers[0];
/*        int min=Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            min= Math.min(min,numbers[i]);
        }
        return min;*/
    }

    public static void main(String[] args) {
        int p=new test11().minArray(new int[]{2,2,2,0,1});
        System.out.println(p);
    }
}
