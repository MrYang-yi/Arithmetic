package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class test29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // left to right.
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }                            // top to bottom.

            if (l > --r) break;
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; // right to left.
            }
            if (t > --b) break;
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.
            }
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new test29().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
