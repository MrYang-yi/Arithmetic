package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.Arrays;

public class lc322_CoinChange {
    public static void main(String[] args) {
        Solution solution = new lc322_CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    //零钱兑换
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {  //从1到11
                for (int j = 0; j < coins.length; j++) { //从0到2
                    if (coins[j] <= i) { //如果当前的硬币值 小于遍历的值
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); //  1代表的是枚举的这枚硬币数量1的贡献，例如dp[1 - coins[0] + 1]
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}