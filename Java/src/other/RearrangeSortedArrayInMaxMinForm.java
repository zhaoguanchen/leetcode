package other;

import java.util.Arrays;

/**
 * Rearrange Sorted Array In MaxMin Form
 */
public class RearrangeSortedArrayInMaxMinForm {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        RearrangeSortedArrayInMaxMinForm rearrangeSortedArrayInMaxMinForm = new RearrangeSortedArrayInMaxMinForm();
        rearrangeSortedArrayInMaxMinForm.maxMin(nums);
        System.out.println(Arrays.toString(nums));
        // 5,1,4,2,3
    }

    /**
     * @Description: Use the remainder to store the actual number and the divisor to store the changed number.
     * @Author: Guanchen Zhao
     * @Date: 2022/6/3
     */
    public void maxMin(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for (int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxIdx] % maxElem) * maxElem;
                maxIdx -= 1;
            } else { // at odd indices we will store minimum elements
                arr[i] = arr[i] + (arr[minIdx] % maxElem) * maxElem;
                minIdx += 1;
            }

        }
        // dividing with maxElem to get original values.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }


}
