package leetcode.solution.array.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1695. Maximum Erasure Value
 */
public class MaximumErasureValue {

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        SolutionWithPrefixSum solutionWithArray = new SolutionWithPrefixSum();
        int ans = solutionWithArray.maximumUniqueSubarray(nums);
        System.out.println(ans);
        // 17
    }


}

/**
 * @Description: Using Prefix Sum
 * @Author: Guanchen Zhao
 * @Date: 2022/6/12
 */
class SolutionWithPrefixSum {

    public int maximumUniqueSubarray(int[] nums) {
        int k = 10001;
        int[] indexArray = new int[k];
        Arrays.fill(indexArray, -1);
        int[] prefixSum = new int[nums.length + 1];
        int right = 0;
        int left = 0;
        int maxSum = 0;
        int currentSum = 0;
        while (right < nums.length) {
            int val = nums[right];
            currentSum += val;
            int base = right == 0 ? 0 : prefixSum[right - 1];
            prefixSum[right] = base + val;

            int lastIndex = indexArray[val];
            if (lastIndex >= left) {
                currentSum = prefixSum[right] - prefixSum[lastIndex];
                left = lastIndex + 1;
            }

            maxSum = Math.max(maxSum, currentSum);
            indexArray[val] = right;
            right++;

        }

        return maxSum;
    }

}

/**
 * @Description: using count array
 * @Author: Guanchen Zhao
 * @Date: 2022/6/12
 */
class SolutionWithArray {

    public int maximumUniqueSubarray(int[] nums) {
        int start = 0;
        int result = 0;
        int currentSum = 0;
        int k = 10001;
        int[] countMap = new int[k];
        for (int end = 0; end < nums.length; end++) {
            int currentElement = nums[end];
            countMap[currentElement]++;
            currentSum += currentElement;
            while (start < end && countMap[currentElement] > 1) {
                countMap[nums[start]]--;
                currentSum -= nums[start];
                start++;
            }
            // update result with maximum sum found so far
            result = Math.max(result, currentSum);
        }
        return result;
    }
}

/**
 * @Description: Using HashSet
 * @Author: Guanchen Zhao
 * @Date: 2022/6/12
 */
class SolutionWithSet {


    public int maximumUniqueSubarray(int[] nums) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;

        Set<Integer> memo = new HashSet<>();

        while (right < nums.length) {
            sum += nums[right];

            while (memo.contains(nums[right])) {
                memo.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            max = Math.max(max, sum);

            memo.add(nums[right]);
            right++;
        }

        return max;
    }
}