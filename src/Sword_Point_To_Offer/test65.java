package Sword_Point_To_Offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class test65 {
    public int add(int a, int b) {
        while (b != 0) {
             int c=(a & b)<<1;
             a^=b;
             b=c;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = new test65().add(4, 5);
        System.out.println(a);
    }
}
