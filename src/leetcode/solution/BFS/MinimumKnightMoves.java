package leetcode.solution.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1197. Minimum Knight Moves
 */
public class MinimumKnightMoves {

    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        MinimumKnightMoves minimumKnightMoves = new MinimumKnightMoves();
        int ans = minimumKnightMoves.minKnightMoves(x, y);
        System.out.println(ans);
        // 5
    }

    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[601][601];
        int[][] direct = new int[][]{{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[300][300] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];

                if (currX == x && currY == y) {
                    return step;
                }
                for (int[] d : direct) {
                    int nextX = currX + d[0];
                    int nextY = currY + d[1];
                    // out of bound
                    if (nextX > 300 || nextX < -300 || nextY > 300 || nextY < -300) {
                        continue;
                    }
                    // visited
                    if (visited[nextX + 300][nextY + 300]) {
                        continue;
                    }
                    visited[nextX + 300][nextY + 300] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }

            step++;
        }

        return step;

    }

}
