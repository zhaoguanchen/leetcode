package leetcode.solution.string;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        BackspaceStringCompareSolution solution = new BackspaceStringCompareSolution();
        boolean ans = solution.backspaceCompare(s, t);
        System.out.println(ans);

        BackspaceStringCompareSolution2 solution2 = new BackspaceStringCompareSolution2();
        ans = solution2.backspaceCompare(s, t);
        System.out.println(ans);
    }


}

/**
 * @Description: Using Stack
 * @Author: Guanchen Zhao
 * @Date: 2022/4/30
 */
class BackspaceStringCompareSolution {


    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }
}

/**
 * @Description: Two pointer
 * @Author: Guanchen Zhao
 * @Date: 2022/4/30
 */
class BackspaceStringCompareSolution2 {


    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        // count the number of character that should be removed due to the appearance of #
        int backS = 0;
        int backT = 0;
        while (i >= 0 || j >= 0) {
            // remove #
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    backS++;
                    i--;
                } else if (backS > 0) {
                    i--;
                    backS--;
                } else {
                    break;
                }
            }

            // remove #
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    backT++;
                    j--;
                } else if (backT > 0) {
                    j--;
                    backT--;
                } else {
                    break;
                }
            }

            // not equal after remove #
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            // either i or j smaller than zero
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

}