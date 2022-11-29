package HighFrequence.stock;

/**
 * 由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
 * 1.未进行过任何操作；
 * 2.只进行过一次买操作；
 * 3.进行了一次买操作和一次卖操作，即完成了一笔交易；
 * 4.在完成了一笔交易的前提下，进行了第二次买操作；
 * 5.完成了全部两笔交易。
 * 由于第一个状态的利润显然为 0,所以对于剩下4个状态，分别将最大利润记为buy,buy_sell,buy2,count
 */
//买卖股票的最佳时机 III
public class lc123_BestTimeToBuyAndSellStockIii {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -prices[0], buy_sell = 0; //在第 0 天时，如果持有股票，那么只能是在第 0 天买入的，对应负收益 -prices[0]
        int buy2 = -prices[0], count = 0;
        for (int i = 1; i < n; ++i) {
            buy = Math.max(buy, -prices[i]);
            buy_sell = Math.max(buy_sell, buy + prices[i]);
            buy2 = Math.max(buy2, buy_sell - prices[i]);
            count = Math.max(count, buy2 + prices[i]);
        }
        return count;
    }
}