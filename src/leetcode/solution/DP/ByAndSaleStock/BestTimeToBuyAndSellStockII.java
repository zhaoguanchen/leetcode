package leetcode.solution.DP.ByAndSaleStock;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStockII buyAndSellStock = new BestTimeToBuyAndSellStockII();
        int ans = buyAndSellStock.maxProfit(nums);
        System.out.println(ans);
        // 7

        int ans1 = buyAndSellStock.maxProfit1(nums);
        System.out.println(ans1);

        int ans2 = buyAndSellStock.maxProfit2(nums);
        System.out.println(ans2);

    }

    /**
     * DP
     * 后一时刻的收益与前一时刻相关
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max_0 = 0;
        int max_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 当前未持有，则1：前一天未持有，维持未持有；2：前一天持有，当天卖出
            max_0 = Math.max(max_0, max_1 + prices[i]);
            // 当前持有，则1：前一天持有，维持持有；2：前一天未持有，当天买入
            max_1 = Math.max(max_1, max_0 - prices[i]);
        }

        return max_0;
    }


    /**
     * 波峰浪谷的方法
     * 找到波谷（最小值）买入，找到下一个波峰卖出
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int peak = 0;
        int valley = 0;
        int ans = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];

            ans += peak - valley;
        }

        return ans;
    }

    /**
     * one pass
     * 逢低买，逢高卖；假设遇到连续递增，也可以累加差值，当作没卖
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
