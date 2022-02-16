package leetcode.solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one leetcode.solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 3};

        System.out.println(Arrays.toString(twoSum(nums, 8)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int diff = target - x;
            if (map.containsKey(diff)) {
                int index = map.get(diff);
                return new int[]{index, i};
            }
            map.put(x, i);
        }
        return null;
    }


}
