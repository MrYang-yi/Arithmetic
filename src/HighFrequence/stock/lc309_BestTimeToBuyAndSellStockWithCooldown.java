package HighFrequence.stock;

////最佳买卖股票时机含冷冻期
public class lc309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];//在第 0 天时，如果持有股票，那么只能是在第 0 天买入的，对应负收益 -prices[0]
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]); //当天手上持有股票的最大收益 = 前一天手上持有股票的最大收益 or 前一天手上就不持有股票，并且不在冷冻期的最大值 + 买股票产生的的负收益
            f[i][1] = f[i - 1][0] + prices[i]; //当天手上不持有股票，并且处于冷冻期中的累计最大收益 = 前一天持有股票的最大收益 + 当天股票的价格
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]); //当天手上不持有股票，并且不在冷冻期中的累计最大收益 = 前一天手上不持有股票，并且处于冷冻期中的累计最大收益 or 前一天手上不持有股票，并且不在冷冻期中的累计最大收益
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}

//空间优化做法
//        if (prices.length == 0) {
//                return 0;
//                }
//
//                int n = prices.length;
//                int f0 = -prices[0];
//                int f1 = 0;
//                int f2 = 0;
//                for (int i = 1; i < n; ++i) {
//        int newf0 = Math.max(f0, f2 - prices[i]);
//        int newf1 = f0 + prices[i];
//        int newf2 = Math.max(f1, f2);
//        f0 = newf0;
//        f1 = newf1;
//        f2 = newf2;
//        }
//
//        return Math.max(f1, f2);

