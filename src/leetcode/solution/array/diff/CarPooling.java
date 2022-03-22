package leetcode.solution.array.diff;

import java.util.Arrays;

/**
 * 1094. Car Pooling
 */
public class CarPooling {

    public static void main(String[] args) {
        int n = 4;
        int[][] nums = {{2, 1, 5}, {3, 3, 7}};
        CarPooling carPooling = new CarPooling();
        boolean ans = carPooling.carPooling(nums, n);
        System.out.println(ans);
        // false
    }

    public boolean carPooling(int[][] trips, int capacity) {
        // 数据范围为 0 - 1000，因此长度设为1001
        DiffArrayCarPooling diff = new DiffArrayCarPooling(1001);
        for (int[] change : trips) {
            // [numPassengers, from, to]
            int left = change[1];
            // 到达to时下车，不需要变更
            int right = change[2] - 1;
            int val = change[0];

            diff.change(left, right, val);
            diff.print();
        }

        int[] ans = diff.getArray();
        for (int item : ans) {
            if (item > capacity) {
                return false;
            }
        }
        return true;
    }
}

class DiffArrayCarPooling {
    private int[] diffArray;

    public DiffArrayCarPooling(int length) {
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