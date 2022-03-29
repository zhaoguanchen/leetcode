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


    private int[][] data;

    public int numEnclaves(int[][] grid) {
        data = grid;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (data[i][0] == 1) {
                helper(i, 0);
            }
            if (data[i][n - 1] == 1) {
                helper(i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (data[0][i] == 1) {
                helper(0, i);
            }
            if (data[m - 1][i] == 1) {
                helper(m - 1, i);
            }
        }


        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void helper(int i, int j) {
        if (i < 0 || j < 0 || i >= data.length || j >= data[0].length) {
            return;
        }
        if (data[i][j] == 0) {
            return;
        }
        data[i][j] = 0;
        helper(i, j - 1);
        helper(i - 1, j);
        helper(i, j + 1);
        helper(i + 1, j);
    }

}
