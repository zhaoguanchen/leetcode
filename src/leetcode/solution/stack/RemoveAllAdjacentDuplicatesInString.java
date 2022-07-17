package leetcode.solution.stack;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String s = "abbaca";
        RemoveAllAdjacentDuplicatesInString decodeString = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(decodeString.removeDuplicates(s));
        // Output: "ca"
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();

    }

}
