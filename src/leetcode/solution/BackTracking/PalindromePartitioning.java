package leetcode.solution.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> ans = palindromePartitioning.partition(s);
        System.out.println(ans);
        // [["a","a","b"],["aa","b"]]
    }


    private List<List<String>> ans;

    private String s;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        this.s = s;
        List<String> path = new ArrayList<>();
        backtrack(0, path);
        return ans;
    }


    private void backtrack(int index, List<String> path) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }


        for (int i = 1; i <= s.length() - index; i++) {
            String current = s.substring(index, index + i);
            if (!isPalindrome(current)) {
                continue;
            }

            path.add(current);
            backtrack(index + i, path);
            path.remove(path.size() - 1);
        }


    }


    private boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }

        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }

}