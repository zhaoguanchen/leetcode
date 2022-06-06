package leetcode.solution.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 */
public class LargestNumber {


    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        LargestNumber solution = new LargestNumber();
        String ans = solution.largestNumber(nums);
        System.out.println(ans);
        // 9534330
    }


    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }

        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        };

        Arrays.sort(str, comparator);

        if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : str) {
            sb.append(s);
        }


        return sb.toString();

    }
}
