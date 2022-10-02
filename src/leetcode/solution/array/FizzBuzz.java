package leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 */
public class FizzBuzz {

    public static void main(String[] args) {
        int n = 3;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> ans = fizzBuzz.fizzBuzz(n);
        System.out.println(ans);
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                ans.add("FizzBuzz");
            } else if (divisibleBy3) {
                ans.add("Fizz");
            } else if (divisibleBy5) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }

        }

        return ans;
    }
}
