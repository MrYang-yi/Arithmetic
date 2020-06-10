package Sword_Point_To_Offer;

/**
 *
 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。


 */
public class test10_1 {
    public int fib(int n) {
        if (n == 0) return 0;
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        int i;
        for (i = 2; i < n+1; i++) {
            a[i] = a[i - 1] + a[i - 2];
            a[i] %= 1000000007;
        }
        return a[n];
    }

    public static void main(String[] args) {
        int p = new test10_1().fib(45);
        System.out.println(p);
    }
}
