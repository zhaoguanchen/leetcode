package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 886. Possible Bipartite
 */
public class PossibleBipartition {

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int n = 5;
        PossibleBipartition isBipartite = new PossibleBipartition();
        System.out.println(isBipartite.possibleBipartite(n, graph));
    }

    /**
     * result
     */
    private boolean ans;

    private List<List<Integer>> table;

    /**
     * 0 means not visited. 1 means blue. means is black.
     */
    private int[] color;

    public boolean possibleBipartite(int n, int[][] dislikes) {
        table = buildAdjacencyList(n, dislikes);
        color = new int[n + 1];
        ans = true;

        // check every node since there may have independent graph.
        // just choose those nodes that not be visited.
        for (int i = 1; i < table.size(); i++) {
            if (color[i] != 0) {
                continue;
            }
            color[i] = 1;
            traverse(i);
        }

        return ans;
    }

    private void traverse(int s) {
        // already got result
        if (!ans) {
            return;
        }

        // traverse its neighbors
        for (int t : table.get(s)) {
            // // new node, paint different color and traverse
            if (color[t] == 0) {
                color[t] = -color[s];
                traverse(t);
            } else {
                // visited, assert if the color is conflict.
                if (color[s] == color[t]) {
                    ans = false;
                }
            }
        }

    }

    /**
     * Build Adjacency List
     *
     * @param n
     * @param dislikes
     * @return
     */
    private List<List<Integer>> buildAdjacencyList(int n, int[][] dislikes) {
        // from 1 to n, so the size of list should be n + 1
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] item : dislikes) {
            int from = item[0];
            int to = item[1];
            // a does not like b, they are neighborhood, connect each other.
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        return graph;
    }

}
