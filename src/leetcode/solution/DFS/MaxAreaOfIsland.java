package leetcode.solution.DFS;

/**
 * 695. Max Area of Island
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        MaxAreaOfIsland numberOfIslands = new MaxAreaOfIsland();
        System.out.println(numberOfIslands.maxAreaOfIsland(grid));
        // 6
    }


    private int[][] data;

    public int maxAreaOfIsland(int[][] grid) {
        data = grid;
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) {
                    ans = Math.max(ans, helper(i, j));
                }
            }
        }

        return ans;
    }

    private int helper(int i, int j) {
        if (i < 0 || j < 0 || i >= data.length || j >= data[0].length) {
            return 0;
        }
        if (data[i][j] == 0) {
            return 0;
        }
        data[i][j] = 0;
        return 1 + helper(i, j - 1) + helper(i - 1, j) + helper(i, j + 1) + helper(i + 1, j);
    }

}
