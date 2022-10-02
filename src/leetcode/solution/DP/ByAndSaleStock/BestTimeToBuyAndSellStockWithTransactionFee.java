package leetcode.solution.DP.ByAndSaleStock;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        BestTimeToBuyAndSellStockWithTransactionFee buyAndSellStock = new BestTimeToBuyAndSellStockWithTransactionFee();
        int ans = buyAndSellStock.maxProfit(nums, fee);
        System.out.println(ans);
        // 8

    }

    /**
     * DP
     * 后一时刻的收益与前一时刻相关
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int max_0 = 0;
        // 第一天就买入，需要手续费
        int max_1 = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            // 当前未持有，则1：前一天未持有，维持未持有；2：前一天持有，当天卖出，卖出不需要手续费
            max_0 = Math.max(max_0, max_1 + prices[i]);
            // 当前持有，则1：前一天持有，维持持有；2：前一天未持有，当天买入，买入需要手续费
            max_1 = Math.max(max_1, max_0 - prices[i] - fee);
        }

        return max_0;
    }


}
