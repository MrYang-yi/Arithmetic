package Project.Any;

/**
 *
 * 面试题42. 连续子数组的最大和
 *
 */
public class MaxSubArray__42 {
    public static int maxSubArray(int a[]) {
        int nAll = a[0]; //记录n个数的最大值
        int nEnd = a[0]; //记录n个数是否包含第n个数的最大值
        for (int i = 1; i < a.length; i++) {
            nEnd = Math.max(nEnd + a[i], a[i]);     //这条语句会出现两个作用
            nAll = Math.max(nEnd, nAll);          //第一个明显的作用是 nEnd加上一个负数  肯定没有原来大
        }                    //第二个作用是 如果前面所有的数的和加上这个数 都 没有这个数大  说明前面所有的数的和是负数 也会筛掉
        return nAll;                   //这种做法有一点不足的是 无法知道最大子数组和的起始和终止位置
    }

    public static void main(String[] args) {
        int p = new MaxSubArray__42().maxSubArray(new int[]{-1, 4, -3, 6, -7, 4, 8, 15, -7, 6});
        System.out.println(p);
    }
}