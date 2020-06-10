package Sword_Point_To_Offer;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 思路：这里有一个很典型的数组越界问题 需要注意一下
 *      就是在new int[n+1] 此时你还是不知道n+1的值是多少
 *      在你进行提前进行赋值时 不能超出n+1的值 所以先假设n的值
 *      然后保证 n+1  >=   赋值的索引 i 中的最大值
 *      例如下面： 你要赋值a[2] 所以 i=2
 *      自然就必须得判断 n==1 的值
 *
 */
public class test10_2 {
    public int numWays(int n) {
        if (n == 0) return 1;
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        int i;
        for (i = 3; i < n+1; i++) {
            a[i] = a[i - 1] + a[i - 2];
            a[i] %= 1000000007;
        }
        return a[n];
    }

    public static void main(String[] args) {
        int p = new test10_2().numWays(0);
        System.out.println(p);
    }
}
