package solution.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 509. Fibonacci Number
 * <p>
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 */
public class FibonacciNumber {


    public static void main(String[] args) {
        int s = 11;
        System.out.println(fib(s));
        System.out.println(fib1(s));
        System.out.println(fib2(s));
        System.out.println(fib3(s));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    public static int fib1(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }


    public static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int pre = 0;
        int last = 1;
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = pre + last;
            pre = last;
            last = res;
        }

        return last;
    }


    private static final Map<Integer, Integer> map = new HashMap<>();
    public static int fib3(int n) {
        map.put(0, 0);
        map.put(1, 1);

        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, fib3(n - 1) + fib3(n - 2));

        return map.get(n);
    }
}
