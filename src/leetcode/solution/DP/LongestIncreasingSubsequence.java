package leetcode.solution.DP;

/**
 * 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }


    public static int lengthOfLIS(int[] nums) {
        int[] count = new int[nums.length];
        // 第一位子序列为1
        count[0] = 1;

        // 依次往后求最长子序列  当前边某节点小于当前节点时，可认为是子序列，求出最大的解
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(count[j], max);
                }
            }
            count[i] = max + 1;
        }

        // 找出结果数组中最大值即为最长子序列
        int res = 0;
        for (int j : count) {
            res = Math.max(res, j);
        }
        return res;

    }


}