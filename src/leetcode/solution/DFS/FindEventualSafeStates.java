package leetcode.solution.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 802. Find Eventual Safe States
 */
public class FindEventualSafeStates {

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        FindEventualSafeStatesSolution solution = new FindEventualSafeStatesSolution();
        List<Integer> ans = solution.eventualSafeNodes(grid);
        System.out.println(ans);
        // [2, 4, 5, 6]
    }


}


class FindEventualSafeStatesSolution {

    private int[] color;

    private int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        this.color = new int[n];
        this.graph = graph;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean curr = dfs(i);
            if (curr) {
                ans.add(i);
            }
        }

        return ans;
    }


    private boolean dfs(int i) {
        if (color[i] == 2) {
            return true;
        }

        if (color[i] == 1) {
            return false;
        }

        color[i] = 1;

        for (int nei : graph[i]) {
            if (color[nei] == 2) {
                continue;
            }

            if (color[nei] == 1) {
                return false;
            }

            if (!dfs(nei)) {
                return false;
            }

        }

        color[i] = 2;

        return true;
    }


}
