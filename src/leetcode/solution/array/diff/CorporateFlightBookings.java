package leetcode.solution.array.diff;

import java.util.Arrays;

/**
 * 1109. Corporate Flight Bookings
 */
public class CorporateFlightBookings {

    public static void main(String[] args) {
        int n = 5;
        int[][] nums = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        CorporateFlightBookings corporateFlightBookings = new CorporateFlightBookings();
        int[] ans = corporateFlightBookings.corpFlightBookings(nums, n);
        System.out.println(Arrays.toString(ans));
        // [10,55,45,25,25]
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        DiffArrayCorporateFlightBookings diff = new DiffArrayCorporateFlightBookings(n);
        for (int[] change : bookings) {
            int left = change[0] - 1;
            int right = change[1] - 1;
            int val = change[2];

            diff.change(left, right, val);
            diff.print();
        }

        return diff.getArray();
    }
}


class DiffArrayCorporateFlightBookings {
    private int[] diffArray;

    public DiffArrayCorporateFlightBookings(int length) {
        diffArray = new int[length];
    }

    public void change(int left, int right, int val) {
        diffArray[left] += val;

        if (right + 1 < diffArray.length) {
            diffArray[right + 1] -= val;
        }
    }


    public int[] getArray() {
        int[] ans = new int[diffArray.length];
        ans[0] = diffArray[0];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + diffArray[i];
        }

        return ans;
    }

    public void print() {
        System.out.println(Arrays.toString(diffArray));
    }


}