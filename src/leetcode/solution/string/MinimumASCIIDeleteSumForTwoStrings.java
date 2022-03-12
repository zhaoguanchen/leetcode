package leetcode.solution.string;

import java.util.Arrays;

/**
 * 5. Longest Palindromic Substring
 */
public class MinimumASCIIDeleteSumForTwoStrings {

    public static void main(String[] args) {
        String s = "sea";
        String s1 = "eat";
        MinimumASCIIDeleteSumForTwoStrings longestPalindromicSubstring = new MinimumASCIIDeleteSumForTwoStrings();
        System.out.println(longestPalindromicSubstring.minimumDeleteSum(s, s1));
    }

    private int[][] memo;

    private String s1;

    private String s2;

    public int minimumDeleteSum(String word1, String word2) {

        memo = new int[word1.length()][word2.length()];

        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        s1 = word1;
        s2 = word2;

        return helper(0, 0);
    }


    private int helper(int p1, int p2) {
        int ans = 0;
        if (p1 == s1.length()) {
            for (int i = p2; i < s2.length(); i++) {
                ans += s2.charAt(i);
            }
            return ans;
        }

        if (p2 == s2.length()) {
            for (int i = p1; i < s1.length(); i++) {
                ans += s1.charAt(i);
            }
            return ans;
        }

        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        if (s1.charAt(p1) == s2.charAt(p2)) {
            memo[p1][p2] = helper(p1 + 1, p2 + 1);

        } else {
            memo[p1][p2] = Math.min(s2.charAt(p2) + helper(p1, p2 + 1),
                    s1.charAt(p1) + helper(p1 + 1, p2));

        }

        return memo[p1][p2];
    }


}
