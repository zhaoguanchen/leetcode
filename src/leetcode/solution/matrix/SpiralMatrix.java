package leetcode.solution.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class SpiralMatrix {


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> list = spiralMatrix.spiralOrder(matrix);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int topBound = 0;
        int bottomBound = m - 1;
        int leftBound = 0;
        int rightBound = n - 1;

        int count = 0;
        while (count < total) {
            // 右移
            if (topBound <= bottomBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    ans.add(matrix[topBound][i]);
                    count++;
                }
                // 上边界下移
                topBound++;
            }

            // 下移
            if (rightBound >= leftBound) {
                for (int i = topBound; i <= bottomBound; i++) {
                    ans.add(matrix[i][rightBound]);
                    count++;
                }
                // 右边界左移
                rightBound--;
            }

            // 左移
            if (bottomBound >= topBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    ans.add(matrix[bottomBound][i]);
                    count++;
                }
                // 下边界上移
                bottomBound--;
            }

            // 上移
            if (leftBound <= rightBound) {
                for (int i = bottomBound; i >= topBound; i--) {
                    ans.add(matrix[i][leftBound]);
                    count++;
                }
                // 左边界右移
                leftBound++;
            }
        }

        return ans;
    }
}
