package leetcode.solution.array;

import java.util.Arrays;

/**
 * 456. 132 Pattern
 */
public class OneThreeTwoPattern {

    public static void main(String[] args) {

        int[] nums = {3, 11, 4, 12, 4, 13, 2, 6, 13, -32};
        OneThreeTwoPattern oneThreeTwoPattern = new OneThreeTwoPattern();
        System.out.println(Arrays.toString(nums));
        boolean ans = oneThreeTwoPattern.find132pattern(nums);
        System.out.println(ans);
    }

    public boolean find132pattern(int[] nums) {
        // corner case
        if (nums.length < 3) {
            return false;
        }
        int[] min = new int[nums.length];

        min[0] = nums[0];

        // calculate the minimum number to left.
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = nums.length - 1, k = nums.length; j >= 0; j--) {
            if (nums[j] > min[j]) {
                // find to right
                while (k < nums.length && nums[k] <= min[j]) {
                    k++;
                }

                // found the result
                if (k < nums.length && nums[k] < nums[j]) {
                    return true;
                }

                // k is the number that greater than min.
                nums[--k] = nums[j];

            }
        }
        return false;
    }

}
