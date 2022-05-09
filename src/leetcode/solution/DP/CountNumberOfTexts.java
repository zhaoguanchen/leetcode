package leetcode.solution.DP;

/**
 * 2266. Count Number of Texts
 */
public class CountNumberOfTexts {


    public static void main(String[] args) {
        String s = "444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664";
        CountNumberOfTexts count = new CountNumberOfTexts();
        int ans = count.countTexts(s);
        System.out.println(ans);
    }

    private String s;

    private int[] memo;

    public int countTexts(String pressedKeys) {
        this.s = pressedKeys;
        memo = new int[s.length()];
        return backtrack(0);

    }


    private int backtrack(int index) {
        if (index >= s.length()) {
            return 1;
        }

        // check memo
        if (memo[index] > 0) {
            return memo[index];
        }

        char curr = s.charAt(index);
        int sum = 0;
        // for 7 and 9, there are 4 characters.
        int size = curr == '7' || curr == '9' ? 4 : 3;
        for (int i = 0; i < size; i++) {
            int next = index + i;
            if (next >= s.length()) {
                break;
            }
            // the next character is not same
            if (s.charAt(next) != curr) {
                break;
            }

            sum += backtrack(next + 1);
            // mod
            sum %= 1000000007;
        }

        // add to memo
        memo[index] = sum;
        return sum;
    }

}