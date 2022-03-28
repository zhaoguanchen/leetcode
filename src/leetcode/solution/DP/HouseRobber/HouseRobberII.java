package leetcode.solution.DP.HouseRobber;

/**
 * 213. House Robber II
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {

//    rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }

  
    public static int rob(int[] nums) {
        int n = nums.length - 1;

        if (n == 0) {
            return nums[n];
        }
        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }

    public static int helper(int[] nums, int start, int end) {
        int pre1 = nums[start];
        int pre2 = Math.max(nums[start], nums[start + 1]);
        int cur = pre2;

        for (int i = start + 2; i <= end; i++) {
            cur = Math.max(nums[i] + pre1, pre2);
            pre1 = pre2;
            pre2 = cur;
        }

        return cur;

    }


}