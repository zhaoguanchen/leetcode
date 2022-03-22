package leetcode.solution.array;

import java.util.Arrays;

/**
 * 303. Range Sum Query - Immutable
 */
public class RangeSumQuery2D {

    public static void main(String[] args) {
        int[][] nums = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};

        NumMatrix numMatrix = new NumMatrix(nums);
        int a = numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
        int b = numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
        int c = numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
        System.out.println(a + "  " + b + "  " + c);
    }


}


class NumMatrix {

    /**
     * 矩阵前缀和
     */
    private int[][] sumArray;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sumArray = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                sumArray[i][j] = getSum(i, j, val);
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(i);
            System.out.println(Arrays.toString(sumArray[i]));
        }

    }


    private int getSum(int row, int col, int value) {
        return get(row - 1, col)
                + get(row, col - 1)
                - get(row - 1, col - 1)
                + value;

    }

    private int get(int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }

        return sumArray[row][col];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (row1 == 0 && col1 == 0) {
            return sumArray[row2][col2];
        }
        col1--;
        row1--;
        return get(row2,col2) - get(row2,col1) - get(row1,col2) + get(row1,col1);

    }
}