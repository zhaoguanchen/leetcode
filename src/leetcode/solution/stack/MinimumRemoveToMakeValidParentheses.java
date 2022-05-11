package leetcode.solution.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 */
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        MinimumRemoveToMakeValidParentheses solution = new MinimumRemoveToMakeValidParentheses();
        String ans = solution.minRemoveToMakeValid(s);
        System.out.println(ans);
        // lee(t(c)o)de
    }

    public String minRemoveToMakeValid(String s) {
        // save the index of invalid ')'
        Set<Integer> set = new HashSet<>();
        // save the index of '('
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(i);
            }
            if (')' == s.charAt(i)) {
                // found invalid ')'
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    // offset
                    stack.pop();
                }
            }
        }

        // all '(' left in the stack are invalid.
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // ignore the index of invalid Parentheses
            if (set.contains(i)) {
                continue;
            }

            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}
