package solution.array;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, -3};

        System.out.println(maxSubArray1(nums));
    }

    /**
     * brute force
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
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

    public static int maxSubArray2(int[] nums) {
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


}
