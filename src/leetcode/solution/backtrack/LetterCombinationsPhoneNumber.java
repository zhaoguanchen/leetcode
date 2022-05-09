package leetcode.solution.backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        String digit = "23";
        LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();
        List<String> ans = letterCombinationsPhoneNumber.letterCombinationBackTrack(digit);
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

    Map<Character, String> map;

    public List<String> letterCombinationBackTrack(String digits) {
        ans = new LinkedList<>();
        this.digits = digits;

        if (digits.isEmpty()) {
            return ans;
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
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
        String values = map.get(c);
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
