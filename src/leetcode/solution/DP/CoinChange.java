package leetcode.solution.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 322. Coin Change
 */
public class CoinChange {


    public static void main(String[] args) {
        int s = 11;
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, s));

        System.out.println(coinChangeArrayAsMemo(coins, s));

        System.out.println(coinChangeBottomToUp(coins, s));
    }

    private static final Map<Integer, Integer> memo = new HashMap<>();

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int number = Integer.MAX_VALUE;

        for (int i : coins) {
            int subNumber = coinChange(coins, amount - i);
            if (subNumber == -1) {
                continue;
            }
            number = Math.min(number, subNumber + 1);
        }
        if (number == Integer.MAX_VALUE) {
            number = -1;
        }

        memo.put(amount, number);
        return number;
    }


    private static int[] memoArray;

    public static int coinChangeArrayAsMemo(int[] coins, int amount) {
        // 采用数组作为"备忘录"，相较于map更高效
        memoArray = new int[amount + 1];
        Arrays.fill(memoArray, -2);
        return dpArrayAsMemo(coins, amount);
    }

    public static int dpArrayAsMemo(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // 无解
        if (amount < 0) {
            return -1;
        }

        // 初始化为-2
        if (memoArray[amount] != -2) {
            return memoArray[amount];
        }

        // 设为int最大值，便于比较
        int number = Integer.MAX_VALUE;

        for (int i : coins) {
            int subNumber = dpArrayAsMemo(coins, amount - i);
            // 子问题无解，跳过
            if (subNumber == -1) {
                continue;
            }
            // 找出最优解
            number = Math.min(number, subNumber + 1);
        }
        // 未找到最优解，无解
        if (number == Integer.MAX_VALUE) {
            number = -1;
        }

        memoArray[amount] = number;
        return number;
    }


    public static int coinChangeBottomToUp(int[] coins, int amount) {
        // 采用数组作为"备忘录"，相较于map更高效
        int[] memoArray2 = new int[amount + 1];
        Arrays.fill(memoArray2, -2);
        memoArray2[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int best = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 不合法情形，跳过
                if (i - coin < 0) {
                    continue;
                }
                int subBest = memoArray2[i - coin];
                // 子问题无解
                if (subBest == -1) {
                    continue;
                }
                best = Math.min(best, subBest);
            }
            if (best == Integer.MAX_VALUE) {
                memoArray2[i] = -1;
            } else {
                memoArray2[i] = best + 1;
            }
        }

        return memoArray2[amount];
    }


}