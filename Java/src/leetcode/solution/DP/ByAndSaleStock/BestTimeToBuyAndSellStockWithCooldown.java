package leetcode.solution.DP.ByAndSaleStock;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 2};
        BestTimeToBuyAndSellStockWithCooldown buyAndSellStock = new BestTimeToBuyAndSellStockWithCooldown();
        int ans = buyAndSellStock.maxProfit(nums);
        System.out.println(ans);
        // 3

    }

    /**
     * DP
     * 后一时刻的收益与前一时刻相关
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max_0 = 0;
        int max_1 = -prices[0];
        int pre_0 = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = max_0;
            // 当前未持有，则1：前一天未持有，维持未持有；2：前一天持有，当天卖出
            max_0 = Math.max(max_0, max_1 + prices[i]);
            // 当前持有，则1：前一天持有，维持持有；2：前2天未持有，当天买入
            max_1 = Math.max(max_1, pre_0 - prices[i]);
            pre_0 = temp;
        }

        return max_0;
    }


}
