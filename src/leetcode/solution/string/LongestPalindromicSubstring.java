package leetcode.solution.string;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        str = s;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            String res1 = helper(i, i);
            String res2 = helper(i, i + 1);
            System.out.println(res1);
            System.out.println(res2);
            String subMax = res1.length() > res2.length() ? res1 : res2;
            ans = ans.length() > subMax.length() ? ans : subMax;
        }

        return ans;
    }


    private String str;

    private String helper(int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        return str.substring(i + 1, j);
    }

}
