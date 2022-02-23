package leetcode.solution.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. Climbing Stairs
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {


    public static void main(String[] args) {
        int s = 3;
        System.out.println(climbStairs(s));
        System.out.println(climbStairs1(s));
    }

    private static final Map<Integer, Integer> map = new HashMap<>();


    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));

        return map.get(n);
    }

    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}