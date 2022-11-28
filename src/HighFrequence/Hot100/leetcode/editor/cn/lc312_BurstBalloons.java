package HighFrequence.Hot100.leetcode.editor.cn;

//戳气球
public class lc312_BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n + 2][n + 2];
        int[] v = new int[n + 2];
        v[0] = v[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            v[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = v[i] * v[k] * v[j];
                    sum += arr[i][k] + arr[k][j];
                    arr[i][j] = Math.max(arr[i][j], sum);
                }
            }
        }
        return arr[0][n + 1];
    }
}