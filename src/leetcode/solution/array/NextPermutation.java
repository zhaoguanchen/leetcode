package leetcode.solution.array;

import java.util.Arrays;

/**
 * 31. Next Permutation
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 9, 5, 4, 3, 1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        // the next should be: 1, 3, 1, 2, 4, 5, 9
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        // find the first element that is greater than the previous element
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // find the greater element on the right side
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // sort from smallest to largest
        reverse(nums, i + 1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

     /**
      * @Description: Reverse using Two Pointer
      * @Author: Guanchen Zhao
      * @Date: 2022/5/16
      */
    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }


    }


}
