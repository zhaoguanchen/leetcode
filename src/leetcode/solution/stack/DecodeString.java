package leetcode.solution.stack;

import java.util.Stack;

/**
 * 394. Decode String
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
        // Output: "aaabcbc"
    }

    public String decodeString(String s) {
        Stack<StringBuilder> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder current = new StringBuilder();

        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (Character.isLetter(ch)) {
                current.append(ch);
            } else if ('[' == ch) {
                countStack.push(k);
                k = 0;
                charStack.push(current);
                current = new StringBuilder();
            } else if (']' == ch) {
                StringBuilder encodeStr = current;
                int times = countStack.pop();
                StringBuilder existStr = charStack.pop();
                for (int j = times; j > 0; j--) {
                    existStr.append(encodeStr);
                }
                current = existStr;
            }
        }

        return current.toString();
    }


}
