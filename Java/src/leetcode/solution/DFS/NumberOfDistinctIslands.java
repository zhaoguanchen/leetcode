package leetcode.solution.DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. Number of Distinct Islands
 */
public class NumberOfDistinctIslands {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        NumberOfDistinctIslands numberOfIslands = new NumberOfDistinctIslands();
        System.out.println(numberOfIslands.numDistinctIslands(grid));
        // 3
    }

    private int[][] data;

    /**
     * four directions
     */
    private int[][] direct;

    public int numDistinctIslands(int[][] grid) {
        data = grid;
        int m = data.length;
        int n = data[0].length;
        this.direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    helper(i, j, sb, "r");
                    String res = sb.toString();
                    set.add(res);
                }
            }
        }
        System.out.println(set);
        return set.size();

    }

    /**
     *
     *
     * @param i
     * @param j
     * @param sb
     * @param source
     */
    private void helper(int i, int j, StringBuilder sb, String source) {
        if (i < 0 || j < 0 || i >= data.length || j >= data[0].length) {
            return;
        }
        if (data[i][j] == 0) {
            return;
        }
        data[i][j] = 0;

        sb.append(source).append("<");
        for (int k = 0; k < direct.length; k++) {
            int[] item = direct[k];
            int nextI = item[0] + i;
            int nextJ = item[1] + j;
            helper(nextI, nextJ, sb, String.valueOf(k));
        }

        sb.append(">").append(source).append(".");

    }

}
