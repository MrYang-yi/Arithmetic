package LeetCode.editor.cn.HighFrequence.swordPointToOffer;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * {
 * {1,   4,  7, 11, 15],
 * {2,   5,  8, 12, 19],
 * {3,   6,  9, 16, 22],
 * {10, 13, 14, 17, 24],
 * {18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class test04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (j >= 0 && i < matrix.length) {
            int a = matrix[i][j];
            if (a > target) {
                j--;
            } else if (a < target) {
                i++;
            } else if (a == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean flag = new test04().findNumberIn2DArray(new int[][]
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }, 5);

        System.out.println(flag);
    }
}

