package leetcode.solution.array.nSum;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 */
public class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {
        int target = 9;
        int[] numbers = {2, 7, 11, 15};

        TwoSumIIInputArrayIsSorted solution = new TwoSumIIInputArrayIsSorted();
        int[] ans = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(ans));

    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];

            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        // In case there is no solution, return {-1, -1}.
        return new int[]{-1, -1};
    }

}
