package leetcode.solution.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 1137. N-th Tribonacci Number
 * <p>
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 */
public class NthTribonacciNumber {


    public static void main(String[] args) {
        int s = 11;
        System.out.println(tribonacci(s));
        System.out.println(tribonacci1(s));
        System.out.println(tribonacci2(s));
//        System.out.println(fib3(s));
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if ((n == 1 || n == 2)) {
            return 1;
        }

        return tribonacci(n - 3) + tribonacci(n - 2) +
                tribonacci(n - 1);

    }

    private static final Map<Integer, Integer> map = new HashMap<>();

    public static int tribonacci1(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        if (!map.containsKey(n)) {
            map.put(n, tribonacci1(n - 3) + tribonacci1(n - 2) +
                    tribonacci1(n - 1));
        }
        return map.get(n);
    }

    public static int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int pre = 0;
        int sec = 1;
        int thr = 1;
        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = pre + sec + thr;
            pre = sec;
            sec = thr;
            thr = res;
        }

        return res;
    }
}