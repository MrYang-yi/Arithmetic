package Sword_Point_To_Offer;

import java.util.Arrays;

/**
 *
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class test40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0) return arr;
        Arrays.sort(arr);
        int[] a=new int[k];
        for (int i = 0; i < k; i++) {
            a[i]=arr[i];
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = new test40().getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        for(int x:a){
            System.out.print(x+" ");
        }
    }
}
