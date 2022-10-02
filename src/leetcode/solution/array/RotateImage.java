package leetcode.solution.array;

import java.util.Arrays;

/**
 * 48. Rotate Image
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    public void rotate(int[][] matrix) {
        rotateDiagonal(matrix);
        rotateLeftRight(matrix);
    }

    /**
     * 对角线翻转
     *
     * @param matrix
     */
    private void rotateDiagonal(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

    }


    /**
     * 上下翻转
     *
     * @param matrix
     */
    private void rotateLeftRight(int[][] matrix) {
        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                swap(matrix, i, j, i, length - 1 - j);

            }
        }
    }


    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }


}
