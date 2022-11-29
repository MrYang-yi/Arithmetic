package HighFrequence.stock;

/**
 * dp[i][0] 表示第i天交易完后手里没有股票的最大利润
 * dp[i][1] 表示第i天交易完后手里持有一支股票的最大利润（i从0开始）
 */
//买卖股票的最佳时机含手续费
//offer63股票的最大利润
public class lc714_BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0]; //在第 0 天时，如果持有股票，那么只能是在第 0 天买入的，对应负收益 -prices[0]
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}