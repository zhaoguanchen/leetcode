package leetcode.solution.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        String digit = "23";
        LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();
        List<String> ans = letterCombinationsPhoneNumber.letterCombinations(digit);
        System.out.println(ans);
    }


    /**
     * back track
     *
     * @param digits
     * @return
     */
    LinkedList<String> ans;

    String digits;

    /**
     * HashMap is also accepted
     */
    String[] memo;

    public List<String> letterCombinations(String digits) {
        ans = new LinkedList<>();
        this.digits = digits;

        if (digits.isEmpty()) {
            return ans;
        }

        memo = new String[10];
        memo[2] = "abc";
        memo[3] = "def";
        memo[4] = "ghi";
        memo[5] = "jkl";
        memo[6] = "mno";
        memo[7] = "pqrs";
        memo[8] = "tuv";
        memo[9] = "wxyz";

        // the select path
        StringBuilder path = new StringBuilder();
        Integer start = 0;
        backtrack(path, start);
        return ans;
    }

    private void backtrack(StringBuilder path, Integer start) {
        // base case
        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }

        char c = digits.charAt(start);
        int index = c - '0';
        String values = memo[index];
        for (char value : values.toCharArray()) {
            // choose the value
            path.append(value);
            // backtrack next position
            backtrack(path, start + 1);
            // revoke the choice
            path.deleteCharAt(path.length() - 1);
        }

    }
}
