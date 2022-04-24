package leetcode.solution.DFS;

/**
 * 200. Number of Islands
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
        // 3
    }

    private char[][] grid;

    private int m;

    private int n;

    /**
     * four directions
     */
    private int[][] direct;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    /**
     * remove adjacent 1, replace with 0
     *
     * @param i
     * @param j
     */
    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        for (int[] item : direct) {
            int nextI = item[0] + i;
            int nextJ = item[1] + j;

            dfs(nextI, nextJ);
        }
    }
}
