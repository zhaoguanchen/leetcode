package leetcode.solution.BinarySearch;

/**
 * 4. Median of Two Sorted Arrays
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] pArray = {};
        int[] pArray1 = {1};
        System.out.println(findMedianSortedArrays(pArray, pArray1));
    }


    /**
     * 双指针法
     * <p>
     * 复杂度 O(m + n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 从0开始，目标点所的值
        int targetIndex = (m + n) / 2;
        // 是否需要前数参与计算
        boolean needLaterOne = (m + n) % 2 == 0;
        int target = 0;
        // 前数
        int another = 0;
        int cur1 = 0;
        int cur2 = 0;

        for (int i = 0; i <= targetIndex; i++) {
            // 遍历过程中，前数一直为target的前一位。这样可以记录前数，便于后面计算。
            another = target;
            if (cur1 == nums1.length) {
                target = nums2[cur2];
                cur2++;
            } else if (cur2 == nums2.length) {
                target = nums1[cur1];
                cur1++;
            } else if (nums1[cur1] < nums2[cur2]) {
                target = nums1[cur1];
                cur1++;
            } else {
                target = nums2[cur2];
                cur2++;
            }

        }
        // 如果需要a+b /2
        if (needLaterOne) {
            return (float) (target + another) / 2;
        } else {
            return (float) (target);
        }

    }
}
