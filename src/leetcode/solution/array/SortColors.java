package leetcode.solution.array;

import java.util.Arrays;

/**
 * 75. Sort Colors
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        // 数字0的指针，指向已知0的后一位
        int pointZero = 0;
        // 数字2的指针
        int pointTwo = nums.length - 1;
        // 扫描指针
        int point = 0;

        while (point <= pointTwo) {
            if (nums[point] == 1) {
                point++;
            } else if (nums[point] == 0) {
                swap(nums, pointZero, point);
                // 指向已知0的后一位
                pointZero++;
                // 指针也后移
                point++;
            } else if (nums[point] == 2) {
                swap(nums, pointTwo, point);
                pointTwo--;
                // 指针不后移，防止2和2交换的情况。此种情况可以在下次循环处理到。
            }
        }


    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
