package leetcode.solution.greedy;

import java.util.Arrays;

/**
 * 135. Candy
 */
public class Candy {


    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        Candy solution = new Candy();
        int ans = solution.candy(nums);
        System.out.println(ans);
        // 5
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        // from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        // from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }

        // calculate the sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[i];
        }

        return sum;

    }
}