package leetcode.solution.math.n;

/**
 * 172. Factorial Trailing Zeroes
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        int s = 0;
        FactorialTrailingZeroes number = new FactorialTrailingZeroes();
        System.out.println(number.trailingZeroes(s));
        // 8
    }

    public int trailingZeroes(int n) {
        int ans = 0;
        int pow5 = 5;
        while (pow5 <= n) {
            ans += n / pow5;
            pow5 = pow5 * 5;
        }
        return ans;
    }
}
