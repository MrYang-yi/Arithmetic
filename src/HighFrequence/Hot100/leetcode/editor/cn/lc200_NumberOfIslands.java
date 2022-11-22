package HighFrequence.Hot100.leetcode.editor.cn;

public class lc200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new lc200_NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

    /**
     * dfs 深度优先搜索
     */
    //岛屿数量
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int islands = 0;
            for (int r = 0; r < grid.length; ++r) {
                for (int c = 0; c < grid[0].length; ++c) {
                    if (grid[r][c] == '1') {
                        ++islands;
                        dfs(grid, r, c);
                    }
                }
            }
            return islands;
        }

        void dfs(char[][] grid, int r, int c) {
            int length = grid.length;
            int width = grid[0].length;
            if (r < 0 || c < 0 || r >= length || c >= width || grid[r][c] == '0') {
                return;
            }
            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }
    }
}