package leetcode.solution.DP;

/**
 * 474. Ones and Zeroes
 */
public class OnesAndZeroes {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        int ans = onesAndZeroes.findMaxForm(strs, m, n);
        System.out.println(ans);
    }

    /**
     * @Description: Dynamic Programming
     * @Author: Guanchen Zhao
     * @Date: 2022/5/23
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = getCount(s);
            int zeroCount = count[0];
            int oneCount = count[1];

            // it may be not critical equation because `at most m and n`.
            for (int zeroes = m; zeroes >= zeroCount; zeroes--) {
                for (int ones = n; ones >= oneCount; ones--) {
                    int choose = 1 + dp[zeroes - zeroCount][ones - oneCount];
                    int notChoose = dp[zeroes][ones];
                    dp[zeroes][ones] = Math.max(choose, notChoose);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * @Description: count the number of 0 and 1
     * @Author: Guanchen Zhao
     * @Date: 2022/5/23
     */
    private int[] getCount(String s) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('0' == s.charAt(i)) {
                zero++;
            } else {
                one++;
            }
        }

        return new int[]{zero, one};
    }
}
