package leetcode.solution.math;

/**
 * 204. Count Primes
 */
public class CountPrimes {

    public static void main(String[] args) {
        int s = 10;
        CountPrimes number = new CountPrimes();
        System.out.println(number.countPrimes(s));

    }

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
            }
        }
        return ans;

    }
}
