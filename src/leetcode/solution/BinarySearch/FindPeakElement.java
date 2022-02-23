package leetcode.solution.BinarySearch;

/**
 * 162. Find Peak Element
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] pArray = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(pArray));

    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + ((end - start) >> 1);
            // 如果中间值比右侧值大，包含mid在内的左区间一定存在peak.
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


}
