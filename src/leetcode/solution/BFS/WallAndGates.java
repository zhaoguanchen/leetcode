package leetcode.solution.BFS;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. Walls and Gates
 */
public class WallAndGates {

    public static void main(String[] args) {
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};

        WallAndGatesBFS bfs = new WallAndGatesBFS();
        bfs.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
//        [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
    }

}


class WallAndGatesBFS {


    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] direct = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    queue.add(pair);
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair<Integer, Integer> node = queue.poll();
                int row = node.getKey();
                int col = node.getValue();
                for (int[] ints : direct) {
                    int nextI = row + ints[0];
                    int nextJ = col + ints[1];
                    // out of bound
                    if (nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n) {
                        continue;
                    }
                    // a wall or already calculated
                    // no need to update because the result calculated in previous loop should be the best.
                    if (rooms[nextI][nextJ] == -1 || rooms[nextI][nextJ] != Integer.MAX_VALUE) {
                        continue;
                    }
                    // update the value
                    rooms[nextI][nextJ] = rooms[row][col] + 1;
                    queue.add(new Pair<>(nextI, nextJ));
                }
            }
        }

    }
}
