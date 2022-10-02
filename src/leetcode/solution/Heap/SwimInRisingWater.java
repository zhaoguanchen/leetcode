package leetcode.solution.Heap;

import leetcode.utils.InputUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 778. Swim in Rising Water
 */
public class SwimInRisingWater {


    public static void main(String[] args) {
        String s = "[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]";
        int[][] grid = InputUtils.generateGrid(5, 5, s);
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int ans = swimInRisingWater.swimInWater(grid);
        System.out.println(ans);
        // 16
    }

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));

        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            // calculate the time
            time = Math.max(time, grid[i][j]);

            // arrive the destination
            if (i == m - 1 && j == n - 1) {
                return time;
            }

            // traverse four directions
            for (int[] direct : directions) {
                int nextI = direct[0] + i;
                int nextJ = direct[1] + j;

                // out of bound
                if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n) {
                    continue;
                }
                // visited
                if (visited[nextI][nextJ]) {
                    continue;
                }
                queue.add(new int[]{nextI, nextJ});
                visited[nextI][nextJ] = true;
            }


        }


        return 0;
    }
}
