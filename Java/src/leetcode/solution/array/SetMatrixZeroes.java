package leetcode.solution.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] nums = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }

            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }

            }
        }

    }


}
