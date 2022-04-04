package leetcode.solution.array;

import java.util.Arrays;

/**
 * 27. Remove Element
 */
public class RemoveElement {

    public static void main(String[] args) {
        int val = 2;
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElement removeElement = new RemoveElement();
        int ans = removeElement.removeElement(nums, val);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 对向双指针
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (val == nums[left]) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }

        }

        return right + 1;
    }

    /**
     * 单向双指针
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
