package solution.stack;

import Structure.ListNode;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "ListNode.constructList(array1)";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char e = stack.pop();
                if (c == ')' && e != '(' || c == '}' && e != '{' || c == ']' && e != '[') {
                    return false;
                }

            }


        }

        return stack.isEmpty();

    }


}
