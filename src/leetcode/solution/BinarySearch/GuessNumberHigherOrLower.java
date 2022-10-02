package leetcode.solution.BinarySearch;

/**
 * 374. Guess Number Higher or Lower
 */
public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        GuessNumberHigherOrLowerSolution solution = new GuessNumberHigherOrLowerSolution(6);
        System.out.println(solution.guessNumber(10));
    }


}


class GuessNumberHigherOrLowerSolution {
    private int base;

    public GuessNumberHigherOrLowerSolution(int base) {
        this.base = base;
    }

    private int guess(int i) {
        return Integer.compare(base, i);
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int ans = guess(mid);
            if (ans == 0) {
                return mid;
            } else if (ans < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }
}