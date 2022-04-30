package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 261. Graph Valid Tree
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        GraphValidTreeSolution solution = new GraphValidTreeSolution();
        boolean ans = solution.validTree(n, edges);
        System.out.println(ans);
        // "false"
    }


}


class GraphValidTreeSolution {

    private Set<Integer> visited;

    private List<List<Integer>> table;

    private boolean ans;

    public boolean validTree(int n, int[][] edges) {
        visited = new HashSet<>();
        this.ans = true;
        this.table = buildAdjacencyList(n, edges);

        // traverse from node 0
        visited.add(0);
        for (int node : table.get(0)) {
            if (!ans) {
                break;
            }
            traverse(0, node);
        }

        // if there were some nodes that not has been reached. It should not be a tree.
        if (visited.size() != n) {
            ans = false;
        }

        return ans;
    }

    /**
     * dfs
     *
     * @param parent the last recently visited node.
     * @param curr   current node
     */
    private void traverse(int parent, int curr) {
        // already get answer
        if (!ans) {
            return;
        }

        // meet visited node, there is a cycle. The answer is false.
        if (visited.contains(curr)) {
            ans = false;
            return;
        }
        // mark as visited
        visited.add(curr);
        for (int node : table.get(curr)) {
            // avoid dead cycle
            if (node == parent) {
                continue;
            }

            traverse(curr, node);
        }
    }

    /**
     * Build Adjacency List
     *
     * @param n
     * @param edges
     * @return
     */
    private List<List<Integer>> buildAdjacencyList(int n, int[][] edges) {
        // Create a new list of lists.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        // Initialise an empty list for each node.
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // Go through the edge list, populating the adjacency list.
        for (int[] item : edges) {
            int from = item[0];
            int to = item[1];
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        }

        return adjacencyList;
    }

}