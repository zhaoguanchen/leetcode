package leetcode.solution.string.twopoint;

/**
 * 1332. Remove Palindromic Subsequences
 */
public class RemovePalindromicSubsequences {

    public static void main(String[] args) {
        String s = "ababa";
        RemovePalindromicSubsequences solution = new RemovePalindromicSubsequences();
        System.out.println(solution.removePalindromeSub(s));
    }

    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (isPalindrome(s)) {
            return 1;
        }

        return 2;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
