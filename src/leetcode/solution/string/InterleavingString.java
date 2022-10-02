package leetcode.solution.string;

/**
 * 97. Interleaving String
 */
public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        InterleavingString interleavingString = new InterleavingString();
        boolean ans = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(ans);
    }

    private String p1;

    private String p2;

    private String p;

    private int[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        p1 = s1;
        p2 = s2;
        p = s3;

        memo = new int[s1.length()][s2.length()];

        return helper(0, 0, 0);
    }


    private boolean helper(int i, int j, int k) {
        if (i == p1.length()) {
            return p2.substring(j).endsWith(p.substring(k));
        }

        if (j == p2.length()) {
            return p1.substring(i).endsWith(p.substring(k));
        }

        if (memo[i][j] > 0) {
            return memo[i][j] == 1;
        }

        boolean ans = false;
        if (p1.charAt(i) == p.charAt(k)) {
            ans = helper(i + 1, j, k + 1);
        }

        if (p2.charAt(j) == p.charAt(k)) {
            ans |= helper(i, j + 1, k + 1);
        }

        // true = 1; false = 2
        memo[i][j] = ans ? 1 : 2;

        return ans;
    }
}
