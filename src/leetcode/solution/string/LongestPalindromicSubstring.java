package leetcode.solution.string;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        StringSolution solution = new StringSolution();
        System.out.println(solution.longestPalindrome(s));
        // babad
    }

}


class StringSolution {

    public String longestPalindrome(String s) {
        str = s;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            String res1 = helper(i, i);
            String res2 = helper(i, i + 1);
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

class PointerSolution {


    private String s;

    public String longestPalindrome(String s) {
        this.s = s;
        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = helper(i, i);
            int length2 = helper(i, i + 1);
            int currentLength = Math.max(length1, length2);
            if (currentLength > length) {
                length = currentLength;
                start = i - (length - 1) / 2;
            }
        }

        return s.substring(start, start + length);
    }


    private int helper(int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}
