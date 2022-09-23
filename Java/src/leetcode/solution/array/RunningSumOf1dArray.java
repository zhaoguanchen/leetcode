package leetcode.solution.array;

import java.util.Arrays;

/**
 * 1480. Running Sum of 1d Array
 */
public class RunningSumOf1dArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        RunningSumOf1dArray sum = new RunningSumOf1dArray();
        int[] ans = sum.runningSum(arr);
        System.out.println(Arrays.toString(ans));
    }


    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = nums[i] + runningSum[i - 1];
        }

        return runningSum;
    }
}
