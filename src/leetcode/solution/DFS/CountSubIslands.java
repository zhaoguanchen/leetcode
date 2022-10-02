package leetcode.solution.DFS;

/**
 * 1905. Count Sub Islands
 */
public class CountSubIslands {

    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        CountSubIslands numberOfIslands = new CountSubIslands();
        int ans = numberOfIslands.countSubIslands(grid1, grid2);
        System.out.println(ans);
        // 3
    }

    private int[][] data2;

    /**
     * four directions
     */
    private int[][] direct;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        data2 = grid2;
        int m = grid1.length;
        int n = grid1[0].length;
        this.direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        // exclude islands that are not sub-island,
        // which means that for some i、j, grid2 == land but grid1 is water
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data2[i][j] == 1 && grid1[i][j] == 0) {
                    helper(i, j);
                }
            }
        }

        // count and remove island, same as '200'
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data2[i][j] == 1) {
                    count++;
                    helper(i, j);
                }
            }
        }

        return count;
    }

    private void helper(int i, int j) {
        if (i < 0 || j < 0 || i >= data2.length || j >= data2[0].length) {
            return;
        }
        if (data2[i][j] == 0) {
            return;
        }

        data2[i][j] = 0;

        for (int[] item : direct) {
            int nextI = item[0] + i;
            int nextJ = item[1] + j;
            helper(nextI, nextJ);
        }
    }

}
