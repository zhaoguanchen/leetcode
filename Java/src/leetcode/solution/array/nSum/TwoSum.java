package leetcode.solution.array.nSum;

import java.util.*;

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


    private int[] twoSum1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];
            int sum = leftVal + rightVal;
            if (sum < target) {
                while (left < right && nums[left] == leftVal) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightVal) {
                    right--;
                }
            } else {
                return new int[]{leftVal, rightVal};
            }
        }

        return null;
    }

    private List<List<Integer>> twoSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];
            int sum = leftVal + rightVal;
            if (sum < target) {
                while (left < right && nums[left] == leftVal) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightVal) {
                    right--;
                }
            } else {
                List<Integer> subRes = Arrays.asList(nums[left], nums[right]);
                ans.add(subRes);
                while (left < right && nums[left] == leftVal) {
                    left++;
                }
                while (left < right && nums[right] == rightVal) {
                    right--;
                }
            }
        }
        return ans;
    }


}
