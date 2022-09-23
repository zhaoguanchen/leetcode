package leetcode.solution.array;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
//        5, nums = [0,1,2,3,4,_,_ \
//        ,_,_,_]
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]){
               nums[index] = nums[i];
               index++;
            }
        }

        return index;
    }


}
