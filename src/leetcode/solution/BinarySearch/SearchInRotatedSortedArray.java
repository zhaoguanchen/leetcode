package leetcode.solution.BinarySearch;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 3};
        int target = 3;

        System.out.println(search(array, target));
    }


    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {// 左区间有序（mid 在有序区间）
                // 如果target在左侧区间
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 左区间无序（mid 在无序区间），那右侧区间一定有序
                // 如果target在右侧区间
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
