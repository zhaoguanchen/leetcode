package leetcode.solution.BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        String digit = "23";
        System.out.println(letterCombinations(digit));

    }

    private static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

    }


    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        ans.add("");
        while (!ans.isEmpty() && ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String currentValue = map.get(digits.charAt(remove.length()));
            for (char c : currentValue.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }

}
