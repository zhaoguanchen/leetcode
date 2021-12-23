package solution.other;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


    public static void main(String[] args) {
        int[][] matrix = generateTestData();
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }


    private static int[][] generateTestData() {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};

        return matrix;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int total = matrix[0].length * matrix.length;

        List<Integer> list = new ArrayList<>();

        boolean cyc = true;
        while (cyc) {

            for (int i = left; i <= right && top <= bottom; i++) {
                list.add(matrix[top][i]);
            }

            top++;

            for (int i = top; i <= bottom && left <= right; i++) {
                list.add(matrix[i][right]);
            }

            right--;

            for (int i = right; i >= left && top <= bottom; i--) {
                list.add(matrix[bottom][i]);
            }

            bottom--;

            for (int i = bottom; i >= top && left <= right; i--) {
                list.add(matrix[i][left]);
            }

            left++;

            if (list.size() >= total) {
                cyc = false;
            }
        }


        return list;
    }
}
