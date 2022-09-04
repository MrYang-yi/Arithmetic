package HighFrequence.swordPointToOffer;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class test13 {
    public int movingCount(int m, int n, int k) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 1;
            }
        }
        return f(a, 0, 0, k);
    }


    public int f(int[][] a, int i, int j, int k) {
        //递归停止条件就是达到了边界，或者已经访问过的点，如果不这样的话，递归就会无穷无尽，stackoverflow了！
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || (digit(i) + digit(j)) > k || a[i][j] == 0)
            return 0;

        // 记得要将点设置成已访问，否则程序溢出
        int temp = a[i][j];
        a[i][j] = 0;
        return temp + f(a, i + 1, j, k) + f(a, i - 1, j, k) + f(a, i, j + 1, k) + f(a, i, j - 1, k);
    }


    public int digit(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int p = new test13().movingCount(2, 3, 1);
        System.out.println(p);
    }
}
