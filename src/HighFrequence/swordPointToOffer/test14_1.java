package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 思路： 1 贪心算法  可以利用数学证明 3是每次剪枝的最佳长度
 * 2 动态规划
 */
public class test14_1 {
    public int cuttingRope(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int number;
        int count = 1;
        while (n >= 5) {
            count *= 3;
            n -= 3;
        }
        return n == 0 ? count : count * n;

/*        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int count = a[j] * a[i - j];
                if (max < count) {
                    max = count;
                    a[i] = max;
                }
            }
        }
        return max;*/
    }

    public static void main(String[] args) {
        int p = new test14_1().cuttingRope(12);
        System.out.println(p);
    }

}
