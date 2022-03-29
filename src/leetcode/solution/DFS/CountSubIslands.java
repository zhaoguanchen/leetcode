package leetcode.solution.DFS;

/**
 * 1905. Count Sub Islands
 */
public class CountSubIslands {

    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        CountSubIslands numberOfIslands = new CountSubIslands();
        System.out.println(numberOfIslands.countSubIslands(grid1, grid2));
        // e
    }

    private int[][] data2;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        data2 = grid2;
        int m = grid1.length;
        int n = grid1[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data2[i][j] == 1 && grid1[i][j] == 0) {
                    helper(i, j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data2[i][j] == 1) {
                    ans++;
                    helper(i, j);
                }
            }
        }

        return ans;
    }

    private int helper(int i, int j) {
        if (i < 0 || j < 0 || i >= data2.length || j >= data2[0].length) {
            return 0;
        }
        if (data2[i][j] == 0) {
            return 0;
        }
        data2[i][j] = 0;
        return 1 + helper(i, j - 1) + helper(i - 1, j) + helper(i, j + 1) + helper(i + 1, j);
    }

}
