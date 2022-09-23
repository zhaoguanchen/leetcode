package leetcode.solution.array;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};


        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            if (map.containsKey(i)) {
                int quantity = map.get(i);

                map.put(i, quantity + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i : nums2) {
            if (map.containsKey(i)) {
                int quantity = map.get(i);
                if (quantity > 0) {
                    res.add(i);
                }
                map.put(i, quantity - 1);
            }
        }

        int[] resArray = new int[res.size()];

        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }


}
