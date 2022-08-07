package leetcode.solution.matrix;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 */
public class SpiralMatrixII {


    public static void main(String[] args) {
        int n = 3;
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] ans = spiralMatrixII.generateMatrix(n);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        int total = n * n;
        int topBound = 0;
        int bottomBound = n - 1;
        int leftBound = 0;
        int rightBound = n - 1;

        while (num <= total) {
            // 右移
            if (topBound <= bottomBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    ans[topBound][i] = num;
                    num++;
                }
                // 上边界下移
                topBound++;
            }

            // 下移
            if (rightBound >= leftBound) {
                for (int i = topBound; i <= bottomBound; i++) {
                    ans[i][rightBound] = num;
                    num++;
                }
                // 右边界左移
                rightBound--;
            }

            // 左移
            if (bottomBound >= topBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    ans[bottomBound][i] = num;
                    num++;
                }
                // 下边界上移
                bottomBound--;
            }

            // 上移
            if (leftBound <= rightBound) {
                for (int i = bottomBound; i >= topBound; i--) {
                    ans[i][leftBound] = num;
                    num++;
                }
                // 左边界右移
                leftBound++;
            }
        }

        return ans;
    }
}
