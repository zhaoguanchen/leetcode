package leetcode.solution.backtrack;

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
//        System.out.println(letterCombinations(digit));

        System.out.println(letterCombinationBackTrack(digit));
    }


    private static final Map<Character, String> map = new HashMap<>();

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


    /**
     * for loop
     */
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

    /**
     * back track
     *
     * @param digits
     * @return
     */
    static LinkedList<String> result = new LinkedList<>();
    static String select;

    public static List<String> letterCombinationBackTrack(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        StringBuilder path = new StringBuilder();
        Integer start = 0;
        select = digits;
        backtrack(path, start);
        return result;
    }

    private static void backtrack(StringBuilder path, Integer start) {
        if (path.length() == select.length()) {
            result.add(path.toString());
            return;
        }

        char c = select.charAt(start);
        String values = map.get(c);
        for (char value : values.toCharArray()) {
            path.append(value);
            backtrack(path, start + 1);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
