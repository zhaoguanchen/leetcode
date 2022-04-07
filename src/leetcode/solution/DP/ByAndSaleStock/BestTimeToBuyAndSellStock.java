package leetcode.solution.DP.ByAndSaleStock;

/**
 * 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock buyAndSellStock = new BestTimeToBuyAndSellStock();
        int ans = buyAndSellStock.maxProfit(nums);
        System.out.println(ans);
        // 5

    }

    /**
     * DP
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 未持有
        int max_0 = 0;
        // 持有
        int max_1 = -prices[0];

        for (int i = 1; i < n; i++) {
            // 若当前为不持有，则1：前一天不持有，继续保持；2：前一天持有，今天卖
            // + prices[i]意味着获得了卖股票的钱
            max_0 = Math.max(max_0, max_1 + prices[i]);
            // 若当前为持有，则1：前一天持有，继续保持；2：前一天不持有，今天买入
            // - prices[i]意味着获得了买股票花费的钱
            max_1 = Math.max(max_1, -prices[i]);
        }

        // 最后一天肯定是卖掉的状态
        return max_0;
    }

    /**
     * 找最低和最高
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(price - min, max);
            }
        }
        return max;
    }
}