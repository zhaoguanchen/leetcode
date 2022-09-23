package leetcode.solution.DFS;

/**
 * 329. Longest Increasing Path in a Matrix
 */
public class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        int[][] candidates = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        int ans = longestIncreasingPathInAMatrix.longestIncreasingPath(candidates);
        System.out.println(ans);
        // 4
    }

    /**
     * memory
     */
    private int[][] memo;

    /**
     * direction
     */
    private int[][] direct;

    private int[][] matrix;
    private int m;
    private int n;

    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;

        memo = new int[m][n];

        direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        // every point may be the start point
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int length = backtrack(i, j);
                ans = Math.max(ans, length);
            }
        }

        return ans;
    }

    private int backtrack(int row, int col) {
        if (memo[row][col] > 0) {
            return memo[row][col];
        }

        int maxLength = 1;
        for (int[] cur : direct) {
            int nextI = cur[0] + row;
            int nextJ = cur[1] + col;
            // out of bound
            if (nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n) {
                continue;
            }

            // not increasing
            if (matrix[nextI][nextJ] <= matrix[row][col]) {
                continue;
            }
            // dfs next point
            int subMax = backtrack(nextI, nextJ);
            maxLength = Math.max(maxLength, subMax + 1);
        }

        // memorize
        memo[row][col] = maxLength;
        return maxLength;
    }


}