package HighFrequence.Hot100.leetcode.editor.cn;


public class lc48_RotateImage {
    public static void main(String[] args) {
        Solution solution = new lc48_RotateImage().new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
    }

    /**
     * 1.先沿着"\"对角线翻转
     * 2.再把二维矩阵的每一行翻转
     */
    class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix.length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for (int[] row : matrix) {
                reverse(row);
            }
        }
        private void reverse(int[] row) {
            int i = 0;
            int j = row.length - 1;
            while (i < j) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }
}