package leetcode.solution.BinarySearch;

/**
 * 35. Search Insert Position
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] pArray = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(pArray, target));
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
