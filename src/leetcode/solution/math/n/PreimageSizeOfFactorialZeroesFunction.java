package leetcode.solution.math.n;

/**
 * 793. Preimage Size of Factorial Zeroes Function
 */
public class PreimageSizeOfFactorialZeroesFunction {

    public static void main(String[] args) {
        int s = 3;
        PreimageSizeOfFactorialZeroesFunction number = new PreimageSizeOfFactorialZeroesFunction();
        System.out.println(number.preimageSizeFZF(s));
        // 5
    }


    public int preimageSizeFZF(int k) {
        return (int) (searchRightBound(k) - searchLeftBound(k) + 1);
    }

    private long searchLeftBound(int k) {
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long numOfZero = trailingZeroes(mid);
            if (numOfZero > k) {
                right = mid;
            } else if (numOfZero < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    private long searchRightBound(int k) {
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long numOfZero = trailingZeroes(mid);
            if (numOfZero > k) {
                right = mid;
            } else if (numOfZero < k) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private long trailingZeroes(long n) {
        long ans = 0;
        long pow5 = 5;
        while (pow5 <= n) {
            ans += n / pow5;
            pow5 = pow5 * 5;
        }
        return ans;
    }
}
