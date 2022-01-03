package solution.array;

import java.util.Arrays;

/**
 * 566. Reshape the Matrix
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 * <p>
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 * <p>
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class ReshapeMatrix {

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int total = m * n;
        int[][] newMat = new int[r][c];

        for (int i = 0; i < total; i++) {
            int m1 = i / n;
            int n1 = i % n;
            int r1 = i / c;
            int c1 = i % c;

            newMat[r1][c1] = mat[m1][n1];
        }
        return newMat;
    }

}
