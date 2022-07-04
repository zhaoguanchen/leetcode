package leetcode.solution.greedy;

/**
 * 376. Wiggle Subsequence
 */
public class WiggleSubsequence {


    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        WiggleSubsequence solution = new WiggleSubsequence();
        int ans = solution.wiggleMaxLength(nums);
        System.out.println(ans);
        // 3
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int preDiff = nums[1] - nums[0];
        int count = preDiff == 0 ? 1 : 2;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0 && preDiff <= 0 || diff < 0 && preDiff >= 0) {
                count++;
                preDiff = diff;
            }
        }

        return count;

    }
}