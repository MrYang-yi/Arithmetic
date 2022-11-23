package HighFrequence.Hot100.leetcode.editor.cn;

public class lc240_SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new lc240_SearchA2dMatrixIi().new Solution();

    }

    /**
     * z字行查找 时间复杂度：O(m + n)  空间复杂度：O(1)
     */
    //搜索二维矩阵 II
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int x = 0;
            int y = n - 1;
            while (x < m && y >= 0) {
                if (matrix[x][y] == target) {
                    return true;
                }
                if (matrix[x][y] > target) {
                    --y;
                } else {
                    ++x;
                }
            }
            return false;
        }
    }
}