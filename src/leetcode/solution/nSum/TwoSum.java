package leetcode.solution.nSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum calculator = new TwoSum();
        int[] ans = calculator.twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
        // {0,1}
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (memo.containsKey(temp)) {
                return new int[]{memo.get(temp), i};
            }

            memo.put(nums[i], i);
        }

        return null;

    }
}
