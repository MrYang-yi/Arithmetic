package HighFrequence.stock;

import java.util.Arrays;

/**
 * 用buy[i][j]表示对于数组prices[0..i]中的价格而言，进行恰好j笔交易，并且当前手上持有一支股票，这种情况下的最大利润
 * 用sell[i][j] 表示恰好进行j笔交易，并且当前手上不持有股票，这种情况下的最大利润。
 */
//买卖股票的最佳时机 IV
public class lc188_BestTimeToBuyAndSellStockIv {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell).max().getAsInt();
    }
}