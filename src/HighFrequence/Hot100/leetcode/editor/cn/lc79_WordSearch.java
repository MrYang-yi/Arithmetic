package HighFrequence.Hot100.leetcode.editor.cn;

public class lc79_WordSearch {
    public static void main(String[] args) {
        Solution solution = new lc79_WordSearch().new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    // 单词搜索
    class Solution {
        public boolean exist(char[][] board, String word) {
            int h = board.length;
            int w = board[0].length;
            boolean[][] used = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    boolean flag = check(board, used, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean check(char[][] board, boolean[][] used, int i, int j, String word, int k) {
            if (board[i][j] != word.charAt(k)) {
                return false;
            } else if (k == word.length() - 1) {
                return true;
            }
            used[i][j] = true;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            for (int[] arr : directions) {
                int newi = i + arr[0];
                int newj = j + arr[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!used[newi][newj]) {
                        boolean flag = check(board, used, newi, newj, word, k + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            used[i][j] = false;
            return result;
        }
    }
}