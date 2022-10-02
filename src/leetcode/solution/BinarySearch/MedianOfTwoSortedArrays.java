package leetcode.solution.BinarySearch;

/**
 * 4. Median of Two Sorted Arrays
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double ans = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }


    private int[] nums1;

    private int[] nums2;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        int total = nums1.length + nums2.length;
        // 双数
        if (total % 2 == 0) {
            int left = helper(0, 0, total / 2);
            int right = helper(0, 0, total / 2 + 1);
            return (left + right) / 2.0;
        } else {// 单数，取中间值
            return helper(0, 0, total / 2 + 1);
        }
    }

    private int helper(int start1, int start2, int k) {
        // 其中一个区间已到达尽头，则结果为另一个区间的第k个值
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }

        // 只需要找第一个值，则在两区间的首位产生
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 计算本区间第k/2个数的值，相当于分别在两个数组进行二分
        int medianIndex1 = start1 + k / 2 - 1;
        int medianIndex2 = start2 + k / 2 - 1;

        int median1 = medianIndex1 >= nums1.length ? Integer.MAX_VALUE : nums1[medianIndex1];
        int median2 = medianIndex2 >= nums2.length ? Integer.MAX_VALUE : nums2[medianIndex2];

        // 数组1中的第k/2个值小于数组2中的第k/2个值
        // 则可以排除数组1的前k/2的部分，结果可能在后半区间与数组2中产生。此时将数组1的起始索引后移到 medianIndex1 + 1
        // 同时，需要求的k值减小k/2，为上面排除的区间长度。
        if (median1 <= median2) {
            return helper(medianIndex1 + 1, start2, k - k / 2);
        } else {
            return helper(start1, medianIndex2 + 1, k - k / 2);
        }

    }


}
