package leetcode.solution.string;

/**
 * 2264. Largest 3-Same-Digit Number in String
 */
public class LargestThreeSameDigitNumberInString {

    public static void main(String[] args) {
        String s = "6777133339";
        LargestThreeSameDigitNumberInString solution = new LargestThreeSameDigitNumberInString();
        String ans = solution.largestGoodInteger(s);
        System.out.println(ans);
//        Output: "777"

    }

    /**
     * @Description: Using two pointer.
     * @Author: Guanchen Zhao
     * @Date: 2022/5/9
     */
    public String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length() - 2; i++) {
            // compare
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                char candidate = num.charAt(i);
                int val = candidate - '0';
                // update the maximum number
                max = Math.max(max, val);

            }
        }
        // not found
        if (max == Integer.MIN_VALUE) {
            return "";
        }
        // generate the result String
        return max + "" + max + "" + max;
    }

}
