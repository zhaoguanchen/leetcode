package leetcode.solution.BinarySearch;

/**
 * 100. Same Tree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] pArray = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(pArray, 2));

    }

    public static int search(int[] nums, int target) {
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
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                // 只取右边子数组，防止无限循环
                left = mid + 1;
            } else {
                // 只取左边子数组，防止无限循环
                right = mid - 1;
            }
        }
        return -1;
    }
}
