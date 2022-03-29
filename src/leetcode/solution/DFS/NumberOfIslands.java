package leetcode.solution.DFS;

/**
 * 200. Number of Islands
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
        // 3
    }


    private char[][] data;

    public int numIslands(char[][] grid) {
        data = grid;
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == '1') {
                    ans++;
                    helper(i, j);
                }
            }
        }

        return ans;
    }

    private void helper(int i, int j) {
        if (i < 0 || j < 0 || i >= data.length || j >= data[0].length) {
            return;
        }
        if (data[i][j] == '0') {
            return;
        }
        data[i][j] = '0';
        helper(i, j - 1);
        helper(i - 1, j);
        helper(i, j + 1);
        helper(i + 1, j);
    }

}
