package leetcode.solution.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 746. Min Cost Climbing Stairs
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 */
public class MinCostClimbingStairs {


    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs0(cost));
        System.out.println(minCostClimbingStairs1(cost));
        System.out.println(minCostClimbingStairs2(cost));
        System.out.println(minCostClimbingStairs3(cost));
        System.out.println(minCostClimbingStairs4(cost));
        System.out.println(minCostClimbingStairs5(cost));

    }

    private static final Map<Integer, Integer> map = new HashMap<>();

    /**
     * recursive
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs0(int[] cost) {
        int n = cost.length;
        return Math.min(helper(cost, n - 1), helper(cost, n - 2));
    }

    public static int helper(int[] cost, int n) {
        if (n == 1 || n == 0) {
            return cost[n];
        }

        return cost[n] + Math.min(helper(cost, n - 1), helper(cost, n - 2));
    }


    /**
     * add memorize = array
     *
     * @param cost
     * @return
     */
    private static int[] arr;

    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        arr = new int[n];
        return Math.min(helper1(cost, n - 1), helper1(cost, n - 2));
    }

    public static int helper1(int[] cost, int n) {
        if (n == 1 || n == 0) {
            return cost[n];
        }

        if (arr[n] > 0) {
            return arr[n];
        }

        arr[n] = cost[n] + Math.min(helper1(cost, n - 1), helper1(cost, n - 2));
        return arr[n];
    }

    /**
     * add memorize = map
     *
     * @param cost
     * @return
     */
    private static final Map<Integer, Integer> map2 = new HashMap<>();

    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        return Math.min(helper2(cost, n - 1), helper2(cost, n - 2));
    }

    public static int helper2(int[] cost, int n) {
        if (n == 1 || n == 0) {
            return cost[n];
        }

        if (map2.containsKey(n)) {
            return map2.get(n);
        }

        map2.put(n, cost[n] + Math.min(helper2(cost, n - 1), helper2(cost, n - 2)));
        return map2.get(n);
    }


    /**
     * map
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs3(int[] cost) {
        int n = cost.length + 1;

        for (int i = 2; i < n; i++) {
            int takeOneStep = map.getOrDefault(i - 1, 0) + cost[i - 1];
            int takeTwoSteps = map.getOrDefault(i - 2, 0) + cost[i - 2];
            map.put(i, Math.min(takeOneStep, takeTwoSteps));
        }

        return map.get(n - 1);
    }

    /**
     * bottom to top
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs4(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }

        return Math.min(dp[n - 1], dp[n - 2]);

    }


    public static int minCostClimbingStairs5(int[] cost) {
        int n = cost.length;
        int pre2 = cost[0];
        int pre1 = cost[1];
        if (n < 2) {
            return Math.min(pre1, pre2);
        }
        for (int i = 2; i < n; i++) {
            int cur = cost[i] + Math.min(pre1, pre2);
            pre2 = pre1;
            pre1 = cur;

        }
        return Math.min(pre1, pre2);
    }


}