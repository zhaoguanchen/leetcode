package leetcode.solution.stack;

import java.util.Stack;

/**
 * 316. Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {


    public static void main(String[] args) {
        String s = "cbacdcbc";
        RemoveDuplicateLetters decodeString = new RemoveDuplicateLetters();
        System.out.println(decodeString.removeDuplicateLetters(s));
        // Output: "acdb"
    }

    public String removeDuplicateLetters(String s) {

        int[] count = new int[26];

        char[] chars = s.toCharArray();

        for (char c : chars) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] added = new boolean[26];

        for (char c : chars) {
            int index = c - 'a';
            count[index]--;

            if (added[index]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }

                char pop = stack.pop();

                added[pop - 'a'] = false;
            }

            stack.push(c);
            added[index] = true;


        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();

    }
}
