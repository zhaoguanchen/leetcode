package leetcode.solution.string;

import java.util.Arrays;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s = "sea";
        String s1 = "eat";
        LongestCommonSubsequence longestPalindromicSubstring = new LongestCommonSubsequence();
        System.out.println(longestPalindromicSubstring.minDistance(s, s1));
    }

    private int[][] memo;

    private String s1;

    private String s2;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];

        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        s1 = word1;
        s2 = word2;
        int commonLength = helper(0, 0);

        return (s1.length() - commonLength) + (s2.length() - commonLength);
    }


    private int helper(int p1, int p2) {
        if (p1 == s1.length() || p2 == s2.length()) {
            return 0;
        }

        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        if (s1.charAt(p1) == s2.charAt(p2)) {
            memo[p1][p2] = 1 + helper(p1 + 1, p2 + 1);

        } else {
            memo[p1][p2] = Math.max(helper(p1, p2 + 1), helper(p1 + 1, p2));

        }

        return memo[p1][p2];
    }


}
