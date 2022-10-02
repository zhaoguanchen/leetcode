package leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 */
public class FindKClosestElements {

    public static void main(String[] args) {
        int k = 4, x = 3;
        int[] arr = {1, 2, 3, 4, 5};
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> ans = findKClosestElements.findClosestElements(arr, k, x);
        System.out.println(ans);
    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);

        int left = index;
        int right = index + 1;


        while (right - left + 1 < k) {
            if (left < 0) {
                right++;
                continue;
            }
            if (right > arr.length - 1) {
                left--;
                continue;
            }

            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = left+ 1; i < right; i++) {
            ans.add(arr[i]);
        }

        return ans;

    }


    private int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
}
