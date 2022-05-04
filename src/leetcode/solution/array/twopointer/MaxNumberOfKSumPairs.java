package leetcode.solution.array.twopointer;

import java.util.Arrays;

/**
 * 1679. Max Number of K-Sum Pairs
 */
public class MaxNumberOfKSumPairs {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        MaxNumberOfKSumPairs sumPairs = new MaxNumberOfKSumPairs();
        int ans = sumPairs.maxOperations(nums, k);
        System.out.println(ans);
        // 2
    }

    /**
     * @Description: Two Pointer
     * @Author: Guanchen Zhao
     * @Date: 2022/5/3
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // there should be no available sum now
            if (nums[left] >= k) {
                break;
            }

            // no need to do Addition, just continue.
            if (nums[right] >= k) {
                right--;
                continue;
            }

            if (nums[left] + nums[right] < k) {
                left++;
            } else if (nums[left] + nums[right] > k) {
                right--;
            } else {
                // when we find the pair, move both left pointer and right pointer.
                left++;
                right--;
                count++;
            }
        }
        return count;
    }

}
