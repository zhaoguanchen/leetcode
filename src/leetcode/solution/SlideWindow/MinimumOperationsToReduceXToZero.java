package leetcode.solution.SlideWindow;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 */
public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;

        MinimumOperationsToReduceXToZero solution = new MinimumOperationsToReduceXToZero();
        int ans = solution.minOperations(nums, x);
        System.out.println(ans);
        // 2
    }


    public int minOperations(int[] nums, int x) {
        int left = 0;
        int right = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int remain = sum - x;

        if (remain == 0) {
            return nums.length;
        }

        int maxLength = -1;
        int currentSum = 0;
        while (right < nums.length) {
            currentSum += nums[right];

            while (left <= right && currentSum > remain) {
                currentSum -= nums[left];
                left++;
            }

            if (left <= right && currentSum == remain) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        if (maxLength == -1) {
            return -1;
        }

        return nums.length - maxLength;
    }
}
