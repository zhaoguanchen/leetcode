package leetcode.solution.stack.parentheses;

/**
 * 921. Minimum Add to Make Parentheses Valid
 */
public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {
        String s = "())";
        MinimumAddToMakeParenthesesValid solution = new MinimumAddToMakeParenthesesValid();
        int ans = solution.minAddToMakeValid(s);
        System.out.println(ans);
        // 1
    }

    public int minAddToMakeValid(String s) {
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                leftCount++;
            }
            if (')' == s.charAt(i)) {
                // found invalid ')'
                if (leftCount > 0) {
                    // offset
                    leftCount--;
                } else {
                    // count right
                    rightCount++;
                }
            }
        }

        return leftCount + rightCount;
    }

}
