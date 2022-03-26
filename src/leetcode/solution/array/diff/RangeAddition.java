package leetcode.solution.array.diff;

import java.util.Arrays;

/**
 * 370. Range Addition
 */
public class RangeAddition {

    public static void main(String[] args) {
        int length = 5;
        int[][] nums = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        RangeAddition rangeAddition = new RangeAddition();
        int[] ans = rangeAddition.getModifiedArray(length, nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        DiffArray diffArray = new DiffArray(length);
        for (int[] change : updates) {
            int left = change[0];
            int right = change[1];
            int val = change[2];

            diffArray.change(left, right, val);
            diffArray.print();
        }

        return diffArray.getArray();

    }
}


class DiffArray {
    private int[] diffArray;

    public DiffArray(int length) {
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