package leetcode.solution.DFS;

/**
 * 1020. Number of Enclaves
 */
public class NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        NumberOfEnclaves numberOfIslands = new NumberOfEnclaves();
        System.out.println(numberOfIslands.numEnclaves(grid));
        // 3
    }


    private int[][] grid;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;

        // remove islands near border
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                helper(i, 0);
            }
            if (grid[i][n - 1] == 1) {
                helper(i, n - 1);
            }
        }

        // remove islands near border
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                helper(0, i);
            }
            if (grid[m - 1][i] == 1) {
                helper(m - 1, i);
            }
        }

        // count the grid.
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void helper(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        helper(i, j - 1);
        helper(i - 1, j);
        helper(i, j + 1);
        helper(i + 1, j);
    }

}
