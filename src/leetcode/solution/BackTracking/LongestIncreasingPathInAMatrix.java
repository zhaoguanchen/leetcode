package leetcode.solution.BackTracking;

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

    private boolean[][] visited;

    private int[][] memo;

    private int[][] data;

    private int[][] direct;

    private int m;

    private int n;


    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        data = matrix;

        memo = new int[m][n];
        visited = new boolean[m][n];
        direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentVal = Integer.MIN_VALUE;
                visited[i][j] = true;
                int cur = backtrack(i, j);
                visited[i][j] = false;
                ans = Math.max(ans, cur);
            }
        }

        return ans;
    }

    private int backtrack(int i, int j) {


        if (memo[i][j] > 0) {
            return memo[i][j];
        }


        int max = 1;
        for (int[] cur : direct) {
            int nextI = cur[0] + i;
            int nextJ = cur[1] + j;
            // 越界，跳过
            if (nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n) {
                continue;
            }

            // 已被访问过或非递增，跳过
            if (visited[nextI][nextJ] || data[nextI][nextJ] <= data[i][j]) {
                continue;
            }
            visited[nextI][nextJ] = true;
            int subMax = backtrack(nextI, nextJ);
            visited[nextI][nextJ] = false;
            max = Math.max(max, subMax + 1);
         }

        memo[i][j] = max;

        return max;

    }


}