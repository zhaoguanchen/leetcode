package leetcode.solution.math.bit;

/**
 * 136. Single Number
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] s = {4, 1, 2, 1, 2};
        SingleNumber number = new SingleNumber();
        System.out.println(number.singleNumber(s));

    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans = ans ^ i;
        }
        return ans;
    }
}
