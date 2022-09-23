package leetcode.solution.math.bit;

/**
 * 231. Power of Two
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        int s = 16;
        PowerOfTwo number = new PowerOfTwo();
        System.out.println(number.isPowerOfTwo(s));

    }

    public boolean isPowerOfTwo(int n) {
        int numOfOne = 0;
        while (n != 0) {
            n = n & (n - 1);
            numOfOne++;
        }
        return numOfOne == 1;
    }
}
