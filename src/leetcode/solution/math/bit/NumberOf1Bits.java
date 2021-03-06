package leetcode.solution.math.bit;

/**
 * 191. Number of 1 Bits
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        int s = 0b11111111111111111111111111111101;
        NumberOf1Bits number = new NumberOf1Bits();
        System.out.println(number.hammingWeight(s));

    }

    /**
     * @Description: n & (n - 1) will eliminate the last 1.
     * @Author: Guanchen Zhao
     * @Date: 2022/5/25
     */
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }

        return ans;
    }
}
