package leetcode.solution.DP;

/**
 * 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int ans = longestIncreasingSubsequence.lengthOfLIS(nums);
        System.out.println(ans);
    }


    public int lengthOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        // the start length will be 1.
        count[0] = 1;

        // dp bottom up
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            // find j that nums[j] < nums[i], they could combine to a larger sequence
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(count[j], max);
                }
            }
            count[i] = max + 1;
        }

        // find the max value
        int res = 0;
        for (int i : count) {
            res = Math.max(res, i);
        }

        return res;

    }


}