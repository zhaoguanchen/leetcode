package solution.other;

/**
 * 476. Number Complement
 * <p>
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 * <p>
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer num, return its complement.
 */
public class NumberComplement {


    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        int n = (int) (Math.log(num) / Math.log(2)) + 1;
        int c = (1 << n) - 1;
        return num ^ c;
    }

}
