package leetcode.solution.DFS;

/**
 * 1254. Number of Closed Islands
 */
public class NumberOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        NumberOfClosedIslands numberOfIslands = new NumberOfClosedIslands();
        int ans = numberOfIslands.closedIsland(grid);
        System.out.println(ans);
        // 2
    }

    private int[][] grid;

    private int m;

    private int n;

    /**
     * four directions
     */
    private int[][] direct;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        // remove the islands close to the border
        // top and bottom
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dfs(i, 0);
            }
            if (grid[i][n - 1] == 0) {
                dfs(i, n - 1);
            }
        }
        // remove the islands close to the border
        // left and right
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                dfs(0, i);
            }
            if (grid[m - 1][i] == 0) {
                dfs(m - 1, i);
            }
        }

        // count the island, same as problem '200. Number of Islands'
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    /**
     * remove islands
     *
     * @param i
     * @param j
     */
    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        for (int[] item : direct) {
            int nextI = item[0] + i;
            int nextJ = item[1] + j;

            dfs(nextI, nextJ);
        }
    }

}
