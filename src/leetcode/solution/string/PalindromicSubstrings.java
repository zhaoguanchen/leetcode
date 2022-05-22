package leetcode.solution.string;

/**
 * 647. Palindromic Substrings
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abc";
        PalindromicSubstringsSolution solution = new PalindromicSubstringsSolution();
        int ans = solution.countSubstrings(s);
        System.out.println(ans);
        // 3

    }


}

/**
 * @Description: Expand Around Possible Centers, also could be seemed as Two Pointer.
 * @Author: Guanchen Zhao
 * @Date: 2022/5/21
 */
class PalindromicSubstringsSolution {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindromic(s, i, i);
            count += countPalindromic(s, i, i + 1);
        }

        return count;
    }


    private int countPalindromic(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

}

