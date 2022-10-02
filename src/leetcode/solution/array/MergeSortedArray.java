package leetcode.solution.array;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int total = m + n - 1;

        for (int i = total; i >= 0; i--) {
            // add num from nums2 directly.
            if (p1 < 0) {
                nums1[i] = nums2[p2];
                p2--;
                continue;
            }
            // all the remaining nums are coming from nums1.
            if (p2 < 0) {
                break;
            }

            if (nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }

        }


    }


}
