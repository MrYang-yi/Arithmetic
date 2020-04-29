package Array;

/**
 * 算法： 子数组的最大和问题 确定起始位置和末位置 接上文
 *
 */
public class maxSubArray3 {
    static int start = 0;
    static int end;
    static int maxSum = Integer.MIN_VALUE; //子数组的最大值

    public static void findIndex(int a[]) {
        int nSum = 0;                //包含子数组最后一位的最大值
        for (int i = 0; i < a.length; i++) {
            if (nSum < 0) {   //说明前面的为负数 起始位置就要改变
                nSum = a[i];
                start = i;
            } else {
                nSum += a[i];
            }
            if (maxSum < nSum) {
                maxSum = nSum;
                end = i;
            }
        }
    }
    public static void main(String[] args) {
        int a[] = {-1, 4, -3, 6, -7, 4, 8, 15, -7, 6};
        findIndex(a);
        System.out.println(start);
        System.out.println(end);
        System.out.println(maxSum);
    }
}
