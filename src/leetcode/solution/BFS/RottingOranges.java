package leetcode.solution.BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 */
public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottingOranges rottingOranges = new RottingOranges();
        int ans = rottingOranges.orangesRotting(grid);
        System.out.println(ans);
        // 4
    }

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] directs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // the time used
        int time = 0;
        // the number of fresh orange
        int freshCount = 0;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }


        while (!queue.isEmpty()) {
            if (freshCount == 0) {
                break;
            }
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair<Integer, Integer> node = queue.poll();
                int i = node.getKey();
                int j = node.getValue();
                for (int[] direct : directs) {
                    int nextI = i + direct[0];
                    int nextJ = j + direct[1];

                    // out of bound
                    if (i < 0 || i >= m || j < 0 || j >= n) {
                        continue;
                    }

                    // is rotten
                    if (grid[nextI][nextJ] == 2) {
                        continue;
                    }

                    // is fresh, rotten it
                    if (grid[nextI][nextJ] == 1) {
                        grid[nextI][nextJ] = 2;
                        freshCount--;
                        queue.add((new Pair<>(nextI, nextJ)));
                    }

                }
            }

            time++;
        }

        if (freshCount > 0) {
            return -1;
        }
        return time;

    }


}