package leetcode.solution.BFS;

import leetcode.utils.InputUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 */
public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        String data = "[[0,0,0],[1,1,0],[1,1,0]]";
        int[][] grid = InputUtils.generateGrid(3, 3, data);
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        int ans = shortestPathInBinaryMatrix.shortestPathBinaryMatrix(grid);
        System.out.println(ans);
        // 4
    }

    /**
     * @Description: BFS
     * @Author: Guanchen Zhao
     * @Date: 2022/5/15
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        // 8 directions
        int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int step = node[2];
            // arrive the end point
            if (row == m - 1 && col == n - 1) {
                return step;
            }

            for (int[] direct : neighbors) {
                int i = row + direct[0];
                int j = col + direct[1];
                // out of bound
                if (i < 0 || i >= m || j < 0 || j >= n) {
                    continue;
                }
                // not available
                if (grid[i][j] == 1) {
                    continue;
                }
                // visited
                if (visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;
                queue.add(new int[]{i, j, step + 1});
            }
        }

        return -1;

    }


}
