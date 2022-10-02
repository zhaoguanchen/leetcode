package leetcode.solution.BinarySearch;

/**
 * 81. Search in Rotated Sorted Array II
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 1, 1, 1, 1};
        int target = 0;

        System.out.println(search(array, target));
    }


    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < right && nums[left] == nums[left + 1])
                ++left;
            while (left < right && nums[right] == nums[right - 1])
                --right;
            int mid = left + ((right - left) >> 1);
            int midValue = nums[mid];

            if (midValue == target) {
                return true;
            } else if (nums[mid] > nums[left]) {// 左区间有序（mid 在有序区间）
                // 如果target在左侧区间
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) { // 右侧区间一定有序
                // 如果target在右侧区间
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 中间值与边界值相等，无法判断哪个子区间有序
                // 左区间收缩，逐步去掉重复值
                left++;
            }
        }

        return false;
    }
}
