package leetcode.solution.DP;

/**
 * 322. Coin Change
 */
public class CoinChange {


    public static void main(String[] args) {
        int s = 11;
        int[] coins = {1, 2, 5};
        CoinChangeSolution solution = new CoinChangeSolution();
        int ans = solution.coinChange(coins, s);
        System.out.println(ans);
    }


}

 /**
  * @Description: Dynamic Programming Bottom up
  * @Author: Guanchen Zhao
  * @Date: 2022/5/21
  */
class CoinChangeSolution {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int coin : coins) {
                int target = i - coin;
                if (target < 0 || memo[target] == -1) {
                    continue;
                }
                count = Math.min(count, memo[target] + 1);
            }
            if (count == Integer.MAX_VALUE) {
                memo[i] = -1;
            } else {
                memo[i] = count;
            }
        }

        return memo[amount];
    }
}