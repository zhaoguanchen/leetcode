package leetcode.solution.stack.parentheses;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = ")()())";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int ans = longestValidParentheses.longestValidParentheses(s);
        System.out.println(ans);
    }


    public int longestValidParentheses(String s) {
        int max = 0;
        // the stack saves the start index of possible valid interval.
        Stack<Integer> stack = new Stack<>();

        // the start index is -1
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // there are no legal parentheses, update the start index.
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // calculate the max
                    // the peek of stack is the start index of current valid interval.
                    max = Math.max(max, i - stack.peek());
                }

            }
        }


        return max;
    }
}



