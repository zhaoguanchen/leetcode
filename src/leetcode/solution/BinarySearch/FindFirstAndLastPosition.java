package leetcode.solution.BinarySearch;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        int[] pArray = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(pArray, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftBound = searchLeftBound(nums, target);
        int rightBound = searchRightBound(nums, target);

        return new int[]{leftBound, rightBound};
    }

    public static int searchLeftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // = 是为了防止数组中只有一个值时跳出的问题（此时left == right）
        while (left <= right) {
            // 为什么不是（left + right）/2
            // 防止相加和溢出
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            // 向左移动右边界 试图找到第一个小于target的数值
            if (midValue == target) {
                right = mid - 1;
            } else if (midValue < target) {
                // 只取右边子数组，防止无限循环
                left = mid + 1;
            } else {
                // 只取左边子数组，防止无限循环
                right = mid - 1;
            }
        }
        // 检查越界
        if (right + 1 >= nums.length || nums[right + 1] != target) {
            return -1;
        }
        return right + 1;
    }

    public static int searchRightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        // = 是为了防止数组中只有一个值时跳出的问题（此时left == right）
        while (left <= right) {
            // 为什么不是（left + right）/2
            // 防止相加和溢出
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            // 向右移动左边界 试图找到第一个大于target的数值
            if (midValue == target) {
                left = mid + 1;
            } else if (midValue < target) {
                // 只取右边子数组，防止无限循环
                left = mid + 1;
            } else {
                // 只取左边子数组，防止无限循环
                right = mid - 1;
            }
        }

        // 检查越界
        if (left - 1 < 0 || nums[left - 1] != target) {
            return -1;
        }
        return left - 1;


    }
}
