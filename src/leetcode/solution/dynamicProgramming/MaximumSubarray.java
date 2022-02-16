package leetcode.solution.dynamicProgramming;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, -3};

        System.out.println(maxSubArray0(nums));
        System.out.println(maxSubArray1(nums));
    }

    /**
     * brute force
     *
     * @param nums
     * @return
     */
    public static int maxSubArray0(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int current = 0;
            for (int j = i; j < nums.length; j++) {
                current += nums[j];
                max = Math.max(max, current);
            }
        }

        return max;

    }

    /**
     * dp
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int max = nums[0];
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + cur);
            max = Math.max(max, cur);
        }

        return max;

    }


    /**
     * divide and conquer
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        array = nums;


        return helper(0, nums.length - 1);

    }

    private static int[] array;

    private static int helper(int left, int right) {
        int mid = Math.floorDiv(right - left, 2);


        int leftSum = 0;
        for (int i = left; i < mid; i++) {
            leftSum += array[i];
        }
        int rightSum = 0;
        for (int i = mid + 1; i < right; i++) {
            rightSum += array[i];
        }

return 1;
    }

}
