package leetcode.solution.Graph;

import java.util.*;

/**
 * 2368. Reachable Nodes With Restrictions
 */
public class ReachableNodesWithRestrictions {

    public static void main(String[] args) {
        ReachableNodesWithRestrictionsSolution solution = new ReachableNodesWithRestrictionsSolution();
        int n = 7;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
        int[] restricted = new int[]{4, 2, 1};

        System.out.println(solution.reachableNodes(n, edges, restricted));
        // 3
    }

}


class ReachableNodesWithRestrictionsSolution {

    private List<List<Integer>> graph;
    private Set<Integer> set;
    private int count;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        this.graph = build(n, edges);
        this.set = new HashSet<>();

        for (int num : restricted) {
            set.add(num);
        }

        this.count = 0;

        dfs(0);

        return count;
    }

    private void dfs(int node) {
        if (set.contains(node)) {
            return;
        }

        count++;
        set.add(node);

        List<Integer> nei = graph.get(node);

        for (int next : nei) {
            dfs(next);
        }

    }

    private List<List<Integer>> build(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        return list;
    }
}
