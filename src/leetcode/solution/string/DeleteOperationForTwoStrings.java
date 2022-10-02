package leetcode.solution.string;

import java.util.Arrays;

/**
 * 583. Delete Operation for Two Strings
 */
public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        String s = "abcde";
        String s1 = "ace";
        DeleteOperationForTwoStrings longestPalindromicSubstring = new DeleteOperationForTwoStrings();
        System.out.println(longestPalindromicSubstring.longestCommonSubsequence(s, s1));
    }

    private int[][] memo;

    private String s1;

    private String s2;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];

        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        s1 = text1;
        s2 = text2;
        return helper(0, 0);
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
