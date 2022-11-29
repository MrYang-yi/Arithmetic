package HighFrequence.Hot100.leetcode.editor.cn;

/**
 * 为了确保每个土地访问不超过一次，我们每次经过一块土地时，将这块土地的值置为 0
 */
//岛屿的最大面积
public class lc695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count = Math.max(count, dfs(grid, i, j));
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int[] arr_i = {0, 0, 1, -1};
        int[] arr_j = {1, -1, 0, 0};  //四个地方发散嘛 上下左右
        int num = 1;
        for (int index = 0; index < 4; ++index) {
            int next_i = i + arr_i[index];
            int next_j = j + arr_j[index];
            num += dfs(grid, next_i, next_j);
        }
        return num;
    }
}