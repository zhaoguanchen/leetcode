package leetcode.solution.greedy;

import java.util.Arrays;

/**
 * 1710. Maximum Units on a Truck
 */
public class MaximumUnitsOnATruck {


    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        MaximumUnitsOnATruck solution = new MaximumUnitsOnATruck();
        int ans = solution.maximumUnits(nums, truckSize);
        System.out.println(ans);
        // 4
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });

        int unitCount = 0;

        for (int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount += boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0) {
                break;
            }

        }

        return unitCount;
    }
}