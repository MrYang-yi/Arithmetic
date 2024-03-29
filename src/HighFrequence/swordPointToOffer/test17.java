package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class test17 {
    public int[] printNumbers(int n) {
        int[] a = new int[(int) Math.pow(10, n)-1];
        for (int i = 0; i < Math.pow(10, n) - 1; i++) {
            a[i] = i + 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new test17().printNumbers(2);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
