package leetcode.solution.array;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        int ans = r.removeDuplicates(nums);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针覆盖法
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
