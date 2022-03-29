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

    public int numDistinctIslands(int[][] grid) {
        data = grid;
        int m = data.length;
        int n = data[0].length;

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

        return set.size();

    }

    private void helper(int i, int j, StringBuilder sb, String source) {
        if (i < 0 || j < 0 || i >= data.length || j >= data[0].length) {
            return;
        }
        if (data[i][j] == 0) {
            return;
        }
        data[i][j] = 0;
        sb.append(source).append(",");

        helper(i, j - 1, sb, "a");
        helper(i - 1, j, sb, "b");
        helper(i, j + 1, sb, "c");
        helper(i + 1, j, sb, "d");
        sb.append("-").append(source).append(",");

    }

}
