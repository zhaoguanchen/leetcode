package leetcode.solution.array.nSum;

import java.util.Arrays;

/**
 * 总结  n sum
 */
public class ThreeSumClosest {


    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        ThreeSumClosest calculator = new ThreeSumClosest();
        int ans = calculator.threeSumClosest(nums, target);
        System.out.println(ans);
        // 2

    }

    public int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (0 != i && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];
                int sum = nums[i] + leftVal + rightVal;
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }


                if (sum < target) {
                    while (left < right && nums[left] == leftVal) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && nums[right] == rightVal) {
                        right--;
                    }
                } else {
                    return target;
                }
            }

        }

        return closest;
    }


}
