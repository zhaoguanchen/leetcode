package leetcode.solution.DP;

/**
 * 63. Unique Paths II
 */
public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // DP Top to Bottom
        UniquePathsIIDPSolution dpSolution = new UniquePathsIIDPSolution();
        int ans = dpSolution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
        // DP Bottom to Top
        UniquePathsIIDPSolution1 dpSolution1 = new UniquePathsIIDPSolution1();
        ans = dpSolution1.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);

        // Backtracking: Time Limit Exceeded
        UniquePathsIIBacktrackSolution solution = new UniquePathsIIBacktrackSolution();
        ans = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(ans);
    }


}

/**
 * @Description: DP Top to Bottom
 * @Author: Guanchen Zhao
 * @Date: 2022/5/19
 */
class UniquePathsIIDPSolution {


    private int[][] grid;

    private int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        int m = grid.length;
        int n = grid[0].length;
        this.memo = new int[m][n];

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return 0;
        }

        return dp(m - 1, n - 1);

    }


    private int dp(int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0 || grid[i][j] == 1) {
            return 0;
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        memo[i][j] = dp(i - 1, j) + dp(i, j - 1);
        return memo[i][j];
    }

}


/**
 * @Description: DP Bottom to Top
 * @Author: Guanchen Zhao
 * @Date: 2022/5/19
 */
class UniquePathsIIDPSolution1 {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        // Filling the base values
        memo[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                memo[i][0] = 0;
            } else {
                memo[i][0] = memo[i - 1][0];
            }
        }

        // Filling the values for the first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                memo[0][j] = 0;
            } else {
                memo[0][j] = memo[0][j - 1];
            }
        }

        // Filling the rest values based the values From above and left.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[m - 1][n - 1];

    }


}

/**
 * @Description: Backtrack; Time Limit Exceeded
 * @Author: Guanchen Zhao
 * @Date: 2022/5/19
 */
class UniquePathsIIBacktrackSolution {

    private int ans;

    private int m;
    private int n;

    private int[][] grid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        ans = 0;
        this.grid = obstacleGrid;
        this.m = grid.length;
        this.n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return ans;
        }

        backtrack(0, 0);
        return ans;
    }


    private void backtrack(int i, int j) {
        if (i == m - 1 && j == n - 1) {
            ans++;
            return;
        }

        if (i >= m || j >= n || grid[i][j] == 1) {
            return;
        }

        backtrack(i + 1, j);
        backtrack(i, j + 1);
    }

}