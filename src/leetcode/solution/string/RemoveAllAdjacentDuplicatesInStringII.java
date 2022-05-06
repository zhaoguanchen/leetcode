package leetcode.solution.string;

import java.util.Stack;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 */
public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        RemoveAllAdjacentDuplicatesInStringII stringII = new RemoveAllAdjacentDuplicatesInStringII();
        System.out.println(stringII.removeDuplicates(s, k));
        // Output: "aa"
    }

    public String removeDuplicates(String s, int k) {
        // using StringBuilder to make it easier to remove character.
        StringBuilder sb = new StringBuilder(s);
        // save the length of duplicate character
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            // it is a single character
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                // same as the previous one.
                int count = stack.pop() + 1;
                // remove and relocate the index location
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    // save the count.
                    stack.push(count);
                }
            }
        }

        return sb.toString();
    }
}
