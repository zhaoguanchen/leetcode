package leetcode.solution.BinarySearch;

/**
 * 74. Search a 2D Matrix
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 8;

        System.out.println(searchMatrix(matrix, target));
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int row = mid / n;
            int column = mid % n;
            int value = matrix[row][column];
            if (value == target) {
                return true;
            } else if (value > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
