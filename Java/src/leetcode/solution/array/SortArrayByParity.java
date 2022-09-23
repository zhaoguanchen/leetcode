package leetcode.solution.array;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] ans = sortArrayByParity.sortArrayByParity(nums);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * @Description: Two Pointer
     * @Author: Guanchen Zhao
     * @Date: 2022/5/1
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            // swap
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }

        return nums;
    }
}
