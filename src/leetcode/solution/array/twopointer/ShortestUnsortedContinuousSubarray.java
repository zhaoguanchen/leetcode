package leetcode.solution.array.twopointer;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Subarray
 */
public class ShortestUnsortedContinuousSubarray {


    public static void main(String[] args) {
        int[] h = {2, 6, 4, 8, 10, 9, 15};
        ShortestUnsortedContinuousSubarraySolution solution = new ShortestUnsortedContinuousSubarraySolution();
        int ans = solution.findUnsortedSubarrayWithSort(h);
        System.out.println(ans);

        ans = solution.findUnsortedSubarrayWithTwoPointer(h);
        System.out.println(ans);
        // 49
    }


}

class ShortestUnsortedContinuousSubarraySolution {


    /**
     * Two Pointer
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayWithTwoPointer(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]) {
                break;
            }
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r]) {
                break;
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }


    /**
     * sort
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayWithSort(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int start = sortedNums.length, end = 0;
        for (int i = 0; i < sortedNums.length; i++) {
            if (sortedNums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

}